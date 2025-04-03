package com.example.lionSurveys.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.lionSurveys.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository< Company, Long> {
    // Custom query methods can be defined here if needed
    // For example:
    // List<Company> findByName(String name);

    Optional <Company> findByName(String name);
    Optional <Company> findById(Long id);
    List<Company> findAll();
    Company save(Company company);
    

}
