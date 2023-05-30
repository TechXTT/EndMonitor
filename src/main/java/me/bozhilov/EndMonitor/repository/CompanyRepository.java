package me.bozhilov.EndMonitor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import me.bozhilov.EndMonitor.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);

    Company findById(long id);

}
