package com.fiberhome.service;

import com.fiberhome.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void insertEmployee(List<Employee> employee);

    public List<Employee> getEmployeeRecords();

    public int updateEmployeeRecords(Employee employee);

    public void deleteEmployeeById(long id);
}
