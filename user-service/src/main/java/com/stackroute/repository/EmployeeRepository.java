package com.stackroute.repository;
import com.stackroute.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

    @Query("{ 'proficiency': ?0 }")
    List<Employee>getEmployeeByProficiency(String proficiency);
}
