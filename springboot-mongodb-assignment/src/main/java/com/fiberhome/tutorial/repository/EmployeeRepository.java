package com.fiberhome.tutorial.repository;

import com.fiberhome.tutorial.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
