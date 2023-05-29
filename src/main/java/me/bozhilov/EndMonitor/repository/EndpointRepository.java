package me.bozhilov.EndMonitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import me.bozhilov.EndMonitor.model.Endpoint;

public interface EndpointRepository extends JpaRepository<Endpoint, Long> {

    List<Endpoint> findAllByApiId(Long apiId);

}
