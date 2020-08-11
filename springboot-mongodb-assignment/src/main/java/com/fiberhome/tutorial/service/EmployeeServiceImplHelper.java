package com.fiberhome.tutorial.service;

import com.fiberhome.tutorial.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImplHelper implements EmployeeServiceHelper {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Employee> getAllEmployee() {
        return mongoTemplate.findAll(Employee.class);
    }

    @Override
    public Employee getEmployeeById(Employee employee) {
        Query query = new Query(Criteria.where("_id").is(employee.getId()));
        return mongoTemplate.findOne(query,Employee.class);
    }

    @Override
    public void insertEmployee(Employee employee) {
        mongoTemplate.insert(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return mongoTemplate.save(employee);
    }

    @Override
    public void deleteEmployeeById(Employee employee) {
        mongoTemplate.remove(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return mongoTemplate.findAll(Employee.class
        );
    }
}
