package com.fiberhome.dao;

import com.fiberhome.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public void insertEmployee(List<Employee> employee);

    public List<Employee> getEmployeeRecords();

    public int updateEmployeeRecord(Employee employee);

    public void deleteEmployeeById(long id);
}
