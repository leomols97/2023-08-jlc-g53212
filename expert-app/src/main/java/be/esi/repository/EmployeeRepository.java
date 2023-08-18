package be.esi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import be.esi.dto.EmployeeTrainingCountDto;
import be.esi.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query("""
                SELECT new be.esi.dto.EmployeeTrainingCountDto(e, COUNT(t))
                FROM Training t JOIN t.employee e
                WHERE t.scheduled>=:sinceDate
                GROUP BY e
            """)
    List<EmployeeTrainingCountDto> countTrainingsForEmployeesSinceDate(@Param("sinceDate") LocalDate sinceDate);

    List<Employee> findAll();
}