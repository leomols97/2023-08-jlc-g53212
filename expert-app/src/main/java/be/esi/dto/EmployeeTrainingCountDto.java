package be.esi.dto;

import be.esi.model.Employee;

public record EmployeeTrainingCountDto(Employee employee, Long trainingsCount) {

}
