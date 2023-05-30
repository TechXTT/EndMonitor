package me.bozhilov.EndMonitor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.bozhilov.EndMonitor.model.Company;
import me.bozhilov.EndMonitor.repository.CompanyRepository;
import me.bozhilov.EndMonitor.service.CompanyService;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Optional<Company> findByName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
