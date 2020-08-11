package com.fiberhome.tutorial.controller;
/**
 * EmployeeManageController curd operation using mongoTemplate
 */

import com.fiberhome.tutorial.model.Employee;
import com.fiberhome.tutorial.service.EmployeeServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeManageController {
    @Autowired
    EmployeeServiceHelper employeeServiceHelper;
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        try {
            List<Employee> employees = employeeServiceHelper.getAllEmployee();

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/getAllEmployeeById")
    public ResponseEntity<Employee> getAllEmployee(@RequestBody Employee employee) {
        try {
            Employee emp = employeeServiceHelper.getEmployeeById(employee);
            return new ResponseEntity<>(emp, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/insertEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        try {
            employeeServiceHelper.insertEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> Employee(@RequestBody Employee employee) {
        try {
            employeeServiceHelper.updateEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee) {
        try {
            employeeServiceHelper.deleteEmployeeById(employee);
            return new ResponseEntity<>(employee.getId()+"Deleted", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
