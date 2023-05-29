package me.bozhilov.EndMonitor.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import me.bozhilov.EndMonitor.model.EndpointTest;

public interface EndpointTestRepository extends JpaRepository<EndpointTest, Long> {

    List<EndpointTest> findAllByEndpointId(Long endpointId);

}
