package be.esi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.esi.business.MainService;
import be.esi.dto.EmployeeTrainingCountDto;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiController {

    @Autowired
    MainService mainService;

    @GetMapping("/amountOfFormation/{formationsCountSinceYear}")
    public ResponseEntity<?> getFormationsCountSince(@PathVariable Integer formationsCountSinceYear) {
        if (formationsCountSinceYear <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            List<EmployeeTrainingCountDto> result = mainService
                    .getEmployeeTrainingCountSinceYear(formationsCountSinceYear);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
