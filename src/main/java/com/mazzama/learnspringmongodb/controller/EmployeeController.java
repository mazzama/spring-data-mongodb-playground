package com.mazzama.learnspringmongodb.controller;

import com.mazzama.learnspringmongodb.Exception.ResourceNotFoundException;
import com.mazzama.learnspringmongodb.model.Employee;
import com.mazzama.learnspringmongodb.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azzam on 25/04/19.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee add(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Employee getOne(@PathVariable String id) {
        return employeeRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @PutMapping(value = "/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        employee.setName(updatedEmployee.getName());
        employee.setExperience(updatedEmployee.getExperience());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setSalary(updatedEmployee.getSalary());
        return employeeRepository.save(employee);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        employeeRepository.delete(employee);
    }

    @GetMapping("/searchByEmail")
    public Employee searchByEmail(@RequestParam(name = "email") String email) {
        return employeeRepository.findByEmail(email)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/searchByExperience")
    public List<Employee> searchByExperience(@RequestParam(name = "from") Double from, @RequestParam(name = "to", required = false) Double to) {
    if (to != null)
        return employeeRepository.findByExperienceBetween(from, to);
    return employeeRepository.findByExperienceGreaterThan(from);
    }
}
