package me.bozhilov.EndMonitor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import me.bozhilov.EndMonitor.model.Company;
import me.bozhilov.EndMonitor.service.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.findAll();
        if (companies.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(companies);
        }
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Optional<Company> company = Optional.ofNullable(companyService.findById(id));
        if (company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/company", consumes = "application/json", produces = "application/json")
    public Company createCompany(@RequestBody Company company) {
        return companyService.save(company);
    }

    @PostMapping(value = "/company/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable Long id) {
        Optional<Company> companyOptional = Optional.ofNullable(companyService.findById(id));
        if (companyOptional.isPresent()) {
            companyOptional.get().setName(company.getName());
            companyOptional.get().setDescription(company.getDescription());
            companyService.save(companyOptional.get());
            return ResponseEntity.ok(companyOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable Long id) {
        Optional<Company> company = Optional.ofNullable(companyService.findById(id));
        if (company.isPresent()) {
            companyService.deleteById(id);
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
