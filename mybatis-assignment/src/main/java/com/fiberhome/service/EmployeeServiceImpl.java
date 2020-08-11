package com.fiberhome.service;

import com.fiberhome.dao.EmployeeDao;
import com.fiberhome.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;
    @Override
    public void insertEmployee(List<Employee> employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public List<Employee> getEmployeeRecords() {
        return employeeDao.getEmployeeRecords();
    }

    @Override
    public int updateEmployeeRecords(Employee employee) {
        return employeeDao.updateEmployeeRecord(employee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeDao.deleteEmployeeById(id);
    }
}
