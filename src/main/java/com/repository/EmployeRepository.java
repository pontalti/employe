package com.repository;

import java.util.List;
import java.util.Optional;

import com.document.EmployeDocument;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeRepository extends MongoRepository<EmployeDocument, String>{

    @Query("{ salary : { $gte :  ?0, $lte : ?1}}")
    public Optional<List<EmployeDocument>> getEmployesBySalaryRange(Integer from, Integer to);
}
