package me.bozhilov.EndMonitor.service;

import java.util.List;
import java.util.Optional;

import me.bozhilov.EndMonitor.controller.resources.EndpointTestResource;
import me.bozhilov.EndMonitor.model.EndpointTest;

public interface EndpointTestService {

    List<EndpointTestResource> findAll();

    Optional<EndpointTestResource> findById(Long id);

    EndpointTest save(EndpointTestResource endpointTestResource);

}
