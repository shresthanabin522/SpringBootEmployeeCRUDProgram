package com.nabin.SpringBootEmployeeCRUDProgram.repository;

import com.nabin.SpringBootEmployeeCRUDProgram.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
}
