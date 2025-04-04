package com.example.lionSurveys.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.lionSurveys.model.Company;
import com.example.lionSurveys.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository< Department, Long> {
    
    Optional<Department> findByNameAndCompany(String name, Company company);
    Optional<Department> findById(Long id);
    List<Department> findAll();
    @SuppressWarnings("unchecked")
    Department save(Department department);
    List<Department> findByCompany(Company company);
    

}
