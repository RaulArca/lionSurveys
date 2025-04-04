package com.example.lionSurveys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.lionSurveys.model.Company;
import com.example.lionSurveys.model.Department;
import com.example.lionSurveys.services.CompanyService;
import com.example.lionSurveys.services.DepartmentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class apicontroller {
    // This class will handle API requests
    // Add your API endpoints here
    @Autowired
    private CompanyService companyService;
    @Autowired
    private DepartmentService departmentService;

    // Example endpoint
    @RequestMapping("/example")
    public String exampleEndpoint() {
        Company  company = new Company();
        company.setName("Lion Surveys");
        
        company = companyService.saveCompany(company);

        Department  department = new Department("Engineering", company);
        departmentService.saveDepartment(department);
        System.out.println("Department saved: " + department.getName());
        List<Company> companies = companyService.findAll();

        try{
            Department  foundDepartment = departmentService.findByNameAndCompany("Engineering", company.getId());
            System.out.println("Department found: " + foundDepartment);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Department not found: " + e.getMessage());
        }
        
        
        



        return "This is an example endpoint";
    }
}