package com.example.empolyeemanagement.service;

import com.example.empolyeemanagement.exception.UserNotFoundException;
import com.example.empolyeemanagement.model.Employee;
import com.example.empolyeemanagement.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee(){

        return employeeRepository.findAll();
    }


    public Employee updateEmployee(Employee employee){
        System.out.println("\n\nRequest is at Service\n" + employee);
        employeeRepository.save(employee);
        return employeeRepository.findEmployeeByEmployeeCode(employee.getEmployeeCode());

    }

    @Transactional
    public void deleteEmployee(Long id){
        System.out.println("\n\n \t inside Resource Controller \n\n");
        employeeRepository.deleteEmployeeById(id);
    }

//    *** USING OPTIONAL
    public Employee findEmployee(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(
                () -> new UserNotFoundException(
                        "User with the <" + id + "> is not found!!"
                ));
    }
//
//    public Employee findEmployee(Long id){
//        return employeeRepository.findEmployeeById(id);
//    }

}
