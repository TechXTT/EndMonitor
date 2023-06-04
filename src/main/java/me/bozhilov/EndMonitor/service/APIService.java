package me.bozhilov.EndMonitor.service;

import java.util.List;
import java.util.Optional;

import me.bozhilov.EndMonitor.controller.resources.APIResource;
import me.bozhilov.EndMonitor.model.API;

public interface APIService {

    List<APIResource> findAll();

    Optional<APIResource> findById(Long id);

    API save(APIResource apiResource);

    API update(APIResource apiResource, Long id);

    void deleteById(Long id);

}
