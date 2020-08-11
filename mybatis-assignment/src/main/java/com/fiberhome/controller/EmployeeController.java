package com.fiberhome.controller;

import com.fiberhome.model.Employee;
import com.fiberhome.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/insertEmployee")
    public ResponseEntity<List<Employee>> insertEmployeeRecords(@RequestBody List<Employee> employee){
        employeeService.insertEmployee(employee);
        return new ResponseEntity<List<Employee>>(employee, HttpStatus.CREATED);
    }
    @RequestMapping("/getEmployeeRecords")
    public ResponseEntity<List<Employee>>   getEmployeeRecords(){
        List<Employee> employeeList = employeeService.getEmployeeRecords();
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @PostMapping("/updateEmployeeRecord")
    public ResponseEntity<Long>   updateEmployeeRecords(@RequestBody Employee employee){
        employeeService.updateEmployeeRecords(employee);
        return new ResponseEntity<Long>(employee.getEmployeeId(), HttpStatus.OK);
    }

    @RequestMapping("/deleteEmployeeRecord/{id}")
    public ResponseEntity<Long>   deleteEmployeeRecords(@PathVariable("id") long id){
         employeeService.deleteEmployeeById(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }

}
