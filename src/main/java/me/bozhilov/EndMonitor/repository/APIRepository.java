package me.bozhilov.EndMonitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import me.bozhilov.EndMonitor.model.API;

public interface APIRepository extends JpaRepository<API, Long> {

    List<API> findAllByCompanyId(Long companyId);

}
