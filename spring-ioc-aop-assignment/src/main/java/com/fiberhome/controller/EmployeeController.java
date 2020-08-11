package com.fiberhome.controller;

import com.fiberhome.model.Employee;
import com.fiberhome.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ResponseEntity<Employee> addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

		return new ResponseEntity<Employee>(employeeService.createEmployee(name, empId), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
	public String removeEmployee( @RequestParam("empId") String empId) {

		employeeService.deleteEmployee(empId);

		return "Employee removed";
	}

}