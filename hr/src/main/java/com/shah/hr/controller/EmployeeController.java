package com.shah.hr.controller;

import com.shah.hr.exception.ResourceNotFoundException;
import com.shah.hr.model.Employee;
import com.shah.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/hr")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
        // TODO : Support pagination .. something like below using a variable page we receive here
        // Query query = entityManager.createQuery("From Employee");
        // int pageNumber = page;
        // int pageSize = 10;
        // query.setFirstResult((pageNumber-1) * pageSize); 
        // query.setMaxResults(pageSize);
        // List<Employee> employeeList = query.getResultList();
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "emp_id") Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeId", "emp_id", employeeId));
    }

}
