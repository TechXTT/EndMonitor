package me.bozhilov.EndMonitor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.bozhilov.EndMonitor.controller.resources.CompanyResource;
import me.bozhilov.EndMonitor.model.Company;
import me.bozhilov.EndMonitor.service.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyResource>> getAllCompanies() {
        List<CompanyResource> companies = companyService.findAll();
        if (companies.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(companies);
        }
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<CompanyResource> getCompanyById(@PathVariable Long id) {
        Optional<CompanyResource> company = companyService.findById(id);
        if (company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/company", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Company> createCompany(@RequestBody CompanyResource companyResource) {
        Company company = companyService.save(companyResource);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/company/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Company> updateCompany(@RequestBody CompanyResource companyResource,
            @PathVariable Long id) {
        // pass CompanyResource and id to update method
        Company company = companyService.update(companyResource, id);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable Long id) {
        Optional<CompanyResource> companyResource = companyService.findById(id);
        if (companyResource.isPresent()) {
            companyService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
