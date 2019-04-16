package com.nabin.SpringBootEmployeeCRUDProgram.controller;

import com.nabin.SpringBootEmployeeCRUDProgram.exception.ResourceNotFoundException;
import com.nabin.SpringBootEmployeeCRUDProgram.model.Employee;
import com.nabin.SpringBootEmployeeCRUDProgram.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;

    //Get all employees....
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


    //Adding a new employee....
    @PostMapping("/employees")
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //Get a Single employee....
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id")Long employeeId){

        return employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee","id",employeeId));

    }

    //Update employees....
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,
                                   @Valid @RequestBody Employee employeeDetails){

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee","id",employeeId));
        employee.setName(employeeDetails.getName());
        employee.setAddress(employeeDetails.getAddress());


        Employee updateEmployee = employeeRepository.save(employee);
        return updateEmployee;
    }

    //Delete Employee....
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id")Long employeeId){

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("employee","id",employeeId));
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
