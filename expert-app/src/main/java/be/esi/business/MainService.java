package be.esi.business;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.esi.dto.EmployeeTrainingCountDto;
import be.esi.model.Employee;
import be.esi.model.Skill;
import be.esi.model.Training;
import be.esi.repository.EmployeeRepository;
import be.esi.repository.SkillRepository;
import be.esi.repository.TrainingRepository;

@Service
public class MainService {

    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Training> getTrainingsOrderedByScheduled() {
        return trainingRepository.findAllByOrderByScheduledAsc();
    }

    public Long countNumberOfTrainingsForEmployeeAndScheduled(String employeeId, LocalDate scheduled) {
        return trainingRepository.countByEmployeeIdAndScheduled(employeeId, scheduled);
    }

    public void addTraining(Training training) {
        trainingRepository.save(training);
    }

    public Skill getSkillById(int skillId) {
        return skillRepository.findById(skillId);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Récupère le nombre de formations suivies par chaque employé depuis une année
     * donnée.
     *
     * @param sinceYear Année de début pour compter les formations.
     * @return Liste des employés avec le nombre de formations suivies depuis
     *         l'année donnée.
     * @throws IllegalArgumentException si l'année est négative ou si une autre
     *                                  erreur survient.
     */
    public List<EmployeeTrainingCountDto> getEmployeeTrainingCountSinceYear(Integer sinceYear) {
        // Permet d'adapter l'année à une date. Il faut que la date soit le premier jour
        // de l'année
        if (sinceYear <= 0) {
            throw new IllegalArgumentException("L'année doit être un nombre strictement positif.");
        }

        try {
            LocalDate sinceDate = LocalDate.of(sinceYear, 1, 1);
            return employeeRepository.countTrainingsForEmployeesSinceDate(sinceDate);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("L'année fournie est invalide.", e);
        }
    }

}
