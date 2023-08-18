package be.esi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.esi.business.MainService;
import be.esi.model.Skill;
import be.esi.model.Training;
import jakarta.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("trainingsList", mainService.getTrainingsOrderedByScheduled());
        return "home";
    }

    @GetMapping("/trainings/{skillId}/addTraining")
    public String addTraining(Model model, @PathVariable("skillId") Integer skillId) {
        model.addAttribute("skill", mainService.getSkillById(skillId));
        model.addAttribute("employeesList", mainService.getAllEmployees());
        model.addAttribute("training", new Training());
        return "addTraining";
    }

    @PostMapping("/trainings/{skillId}/addTraining")
    public String addTraining(Model model, @PathVariable("skillId") Integer skillId, @Valid Training training,
            Errors errors, RedirectAttributes redirectAttrs) {
        String return_value = "addTraining";
        if (errors.hasErrors()) {
            model.addAttribute("skill", mainService.getSkillById(skillId));
            model.addAttribute("employeesList", mainService.getAllEmployees());
            model.addAttribute("training", training);
            return return_value;
        } else {
            Skill skill = mainService.getSkillById(skillId);
            Long numberOfTrainingsForEmployeeOnADay = mainService.countNumberOfTrainingsForEmployeeAndScheduled(
                    training.getEmployee().getId(),
                    training.getScheduled());
            // List<Training> trainings = mainService.getTrainingsOrderedByScheduled();
            // for (Training t : trainings) {
            // if (t.getEmployee().getId().equals(training.getEmployee().getId())) {
            // if (t.getScheduled().equals(training.getScheduled())) {
            if (numberOfTrainingsForEmployeeOnADay > 0) {
                model.addAttribute("skill", mainService.getSkillById(skillId));
                model.addAttribute("employeesList", mainService.getAllEmployees());
                model.addAttribute("training", training);
                errors.rejectValue("employee", "Duplicate.training.date",
                        "L'employé " + training.getEmployee().getName() + " a déjà la formation \""
                                + skill.getName() + "\" prévue le "
                                + training.getScheduled());
                return return_value;
                // }
                // }
            }
            training.setSkill(skill);
            mainService.addTraining(training);
            redirectAttrs.addAttribute("skillId", skillId);
            return_value = "redirect:/";
        }
        return return_value;
    }
}
