package me.bozhilov.EndMonitor.service;

import java.util.List;
import java.util.Optional;

import me.bozhilov.EndMonitor.model.Company;

public interface CompanyService {

    List<Company> findAll();

    Optional<Company> findById(Long id);

    Optional<Company> findByName(String name);

    Company save(Company company);

    void deleteById(Long id);
}
