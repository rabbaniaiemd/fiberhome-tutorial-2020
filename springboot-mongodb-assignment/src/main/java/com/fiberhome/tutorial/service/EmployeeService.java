package com.fiberhome.tutorial.service;

import com.fiberhome.tutorial.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    /**
     *getAllEmployee
     * @return List<Employee>
     */
    public List<Employee> getAllEmployee();

    /**
     * getEmployeeById
     * @param id String
     * @return
     */
    public Optional<Employee> getEmployeeById(String id);

    /**
     * insertEmployee
     * @param employee Employee
     */
    public void insertEmployee(Employee employee);

    /**
     * updateEmployee
     * @param employee
     * @return Employee
     */
    public Employee updateEmployee(Employee employee);

    /**
     * deleteEmployeeById
     * @param id String
     */
    public void deleteEmployeeById(String id);

    /**
     *getAllEmployee
     * @return List<Employee>
     */
    public List<Employee> getAllEmployees();


}
