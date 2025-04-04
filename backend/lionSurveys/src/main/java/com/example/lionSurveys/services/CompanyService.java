package com.example.lionSurveys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lionSurveys.model.Company;
import com.example.lionSurveys.repositories.CompanyRepository;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }
    public Company findByName(String name) {
        Optional<Company> company = companyRepository.findByName(name);
        if(company.isPresent()) {
            return company.get();
        }
        else {
            throw new IllegalArgumentException("Company with name " + name + " does not exist.");
        }
    }
    public Company findById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()) {
            return company.get();
        }
        else {
            throw new IllegalArgumentException("Company with id " + id + " does not exist.");
        }
    }
    public List<Company> findAll() {
        return (List<Company>) companyRepository.findAll();
    }
    public void deleteById(Long id) throws IllegalArgumentException {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            companyRepository.delete(company.get());
        }
        else {
            throw new IllegalArgumentException("Company with id " + id + " does not exist.");
        }
    }
}
