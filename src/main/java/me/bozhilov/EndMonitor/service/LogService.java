package me.bozhilov.EndMonitor.service;

import java.util.List;

import me.bozhilov.EndMonitor.controller.resources.LogResource;
import me.bozhilov.EndMonitor.model.Log;

public interface LogService {

    List<LogResource> findAll();

    Optional<LogResource> findById(Long id);

    Log save(LogResource logResource);

}
