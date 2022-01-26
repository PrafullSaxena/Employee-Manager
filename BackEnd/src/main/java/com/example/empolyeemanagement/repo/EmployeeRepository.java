package com.example.empolyeemanagement.repo;

import com.example.empolyeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
    Employee findEmployeeByEmployeeCode(String employeeCode);

//    Employee findEmployeeById(Long id);
}
