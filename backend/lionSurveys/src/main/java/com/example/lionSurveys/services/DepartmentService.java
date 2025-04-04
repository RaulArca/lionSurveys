package com.example.lionSurveys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lionSurveys.model.Company;
import com.example.lionSurveys.model.Department;
import com.example.lionSurveys.repositories.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository    departmentRepository;
    @Autowired
    private CompanyService          companyService;

    public void saveDepartment(Department company) {
        departmentRepository.save(company);
    }
    /**
     * Finds a department by its name and the company it belongs to.
     * @param name  the name of the department
     * @param companyId  the ID of the company
     * @return the department if found
     * @throws IllegalArgumentException if the department or company is not found
     */
    public Department findByNameAndCompany(String name, Long companyId) throws IllegalArgumentException {
        Company company = companyService.findById(companyId);
        if (company == null) {
            throw new IllegalArgumentException("Company not found");
        }

        Optional<Department> department = departmentRepository.findByNameAndCompany(name, company);
        if (department.isPresent()) {
            return department.get();
        } else {
            throw new IllegalArgumentException("Department not found");
        }



    }
    public Department findById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department == null) {
            throw new IllegalArgumentException("Department not found");
        }
        return department;
    }

    public void deleteDepartment(Long id) {
        Department department = findById(id);
        if (department != null) {
            departmentRepository.delete(department);
        } else {
            throw new IllegalArgumentException("Department not found");
        }
    }
    public List<Department> findAll() {
        return (List<Department>) departmentRepository.findAll();
    }
    public List<Department> findByCompany(Company company) {
        return departmentRepository.findByCompany(company);
    }
    

}
