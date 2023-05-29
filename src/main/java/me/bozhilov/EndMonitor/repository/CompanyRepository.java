package me.bozhilov.EndMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.bozhilov.EndMonitor.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByName(String name);

    Company findById(long id);

}
