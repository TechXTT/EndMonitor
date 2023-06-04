package me.bozhilov.EndMonitor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.bozhilov.EndMonitor.controller.resources.CompanyResource;
import me.bozhilov.EndMonitor.model.Company;
import me.bozhilov.EndMonitor.repository.CompanyRepository;
import me.bozhilov.EndMonitor.service.CompanyService;

import static me.bozhilov.EndMonitor.mapper.CompanyMapper.companyMapper;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyResource> findAll() {
        return companyMapper.toCompanyResourceList(companyRepository.findAll());
    }

    @Override
    public Optional<CompanyResource> findById(Long id) {
        return Optional.ofNullable(companyMapper.toCompanyResource(companyRepository.findById(id).orElse(null)));
    }

    @Override
    public Optional<CompanyResource> findByName(String name) {
        return Optional.ofNullable(companyMapper.toCompanyResource(companyRepository.findByName(name).orElse(null)));
    }

    @Override
    public Company save(CompanyResource companyResource) {
        Company company = companyMapper.fromCompanyResource(companyResource);
        return companyRepository.save(company);
    }

    @Override
    public Company update(CompanyResource companyResource, Long id) {
        Company company = companyMapper.fromCompanyResource(companyResource);
        company.setId(id);
        return companyRepository.save(company);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
