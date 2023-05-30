package me.bozhilov.EndMonitor.service;

import java.util.List;

import me.bozhilov.EndMonitor.controller.resources.EndpointResource;
import me.bozhilov.EndMonitor.model.Endpoint;

public interface EndpointService {

    List<EndpointResource> findAll();

    Optional<EndpointResource> findById(Long id);

    Endpoint save(EndpointResource endpointResource);

}
