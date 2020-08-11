package com.fiberhome.tutorial.service;

import com.fiberhome.tutorial.model.Employee;

import java.util.List;

public interface EmployeeServiceHelper {

    /**
     *getAllEmployee
     * @return List<Employee>
     */
    public List<Employee> getAllEmployee();

    /**
     * getEmployeeById
     * @param employee String
     * @return
     */
    public Employee getEmployeeById(Employee employee);

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
     * @param employee String
     */
    public void deleteEmployeeById(Employee employee);

    /**
     *getAllEmployee
     * @return List<Employee>
     */
    public List<Employee> getAllEmployees();



}


