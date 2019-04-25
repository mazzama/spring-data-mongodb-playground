package com.mazzama.learnspringmongodb.repository;

import com.mazzama.learnspringmongodb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by azzam on 25/04/19.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
