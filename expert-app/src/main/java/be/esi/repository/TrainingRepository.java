package be.esi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import be.esi.model.Training;

public interface TrainingRepository extends CrudRepository<Training, Integer> {

    List<Training> findAllByOrderByScheduledAsc();

    Long countByEmployeeIdAndScheduled(String employeeId, LocalDate scheduledDate);
}
