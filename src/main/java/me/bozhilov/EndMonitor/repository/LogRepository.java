package me.bozhilov.EndMonitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import me.bozhilov.EndMonitor.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

    List<Log> findAllByEndpointTestId(Long id);

}
