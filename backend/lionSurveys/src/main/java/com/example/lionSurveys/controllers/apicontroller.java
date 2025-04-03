package com.example.lionSurveys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.lionSurveys.model.Company;
import com.example.lionSurveys.services.CompanyService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class apicontroller {
    // This class will handle API requests
    // Add your API endpoints here
    @Autowired
    private CompanyService companyService;

    // Example endpoint
    @RequestMapping("/example")
    public String exampleEndpoint() {
        Company  company = new Company();
        company.setName("Lion Surveys");
        
        companyService.saveCompany(company);



        return "This is an example endpoint";
    }
}