package com.mazzama.learnspringmongodb.repository;

import com.mazzama.learnspringmongodb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by azzam on 25/04/19.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findByEmail(String email);
    List<Employee> findByExperienceGreaterThan(double experience);
    List<Employee> findByExperienceBetween(double from, double to);
}
