package me.bozhilov.EndMonitor.service;

import java.util.List;
import java.util.Optional;

import me.bozhilov.EndMonitor.controller.resources.CompanyResource;
import me.bozhilov.EndMonitor.model.Company;

public interface CompanyService {

    List<CompanyResource> findAll();

    Optional<CompanyResource> findById(Long id);

    Optional<CompanyResource> findByName(String name);

    Company save(CompanyResource companyResource);

    Company update(CompanyResource companyResource, Long id);

    void deleteById(Long id);
}
