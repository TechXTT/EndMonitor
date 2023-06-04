package me.bozhilov.EndMonitor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.bozhilov.EndMonitor.controller.resources.CompanyResource;
import me.bozhilov.EndMonitor.model.Company;
import me.bozhilov.EndMonitor.repository.CompanyRepository;
import me.bozhilov.EndMonitor.service.CompanyService;

import static me.bozhilov.EndMonitor.mapper.CompanyMapper.COMPANY_MAPPER;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyResource> findAll() {
        return COMPANY_MAPPER.toCompanyResourceList(companyRepository.findAll());
    }

    @Override
    public Optional<CompanyResource> findById(Long id) {
        return Optional.ofNullable(COMPANY_MAPPER.toCompanyResource(companyRepository.findById(id).orElse(null)));
    }

    @Override
    public Optional<CompanyResource> findByName(String name) {
        return Optional.ofNullable(
                COMPANY_MAPPER.toCompanyResource(companyRepository.findByName(name).orElse(null)));
    }

    @Override
    public Company save(CompanyResource companyResource) {
        Company company = COMPANY_MAPPER.fromCompanyResource(companyResource);
        return companyRepository.save(company);
    }

    @Override
    public Company update(CompanyResource companyResource, Long id) {
        Company company = COMPANY_MAPPER.fromCompanyResource(companyResource);
        company.setId(id);
        return companyRepository.save(company);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
