package com.example.lionSurveys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lionSurveys.model.Company;
import com.example.lionSurveys.repositories.CompanyRepository;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }
}
