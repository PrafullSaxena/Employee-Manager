package com.example.empolyeemanagement;

import com.example.empolyeemanagement.model.Employee;
import com.example.empolyeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService service;


    @Autowired
    public EmployeeResource(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = service.findAllEmployee();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = service.findEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = service.addEmployee(employee);

        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        System.out.println("\n\nRequest is at Controller\n" + employee);
        Employee updatedEmployee = service.updateEmployee(employee);
        System.out.println("");
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        System.out.println("\n\n \t inside Resource Controller \n\n");
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
