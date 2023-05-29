package me.bozhilov.EndMonitor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import me.bozhilov.EndMonitor.service.EndpointService;
import me.bozhilov.EndMonitor.model.API;
import me.bozhilov.EndMonitor.model.Endpoint;

@RestController
public class EndpointController {

    @Autowired
    private EndpointService endpointService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/endpoints")
    public ResponseEntity<List<Endpoint>> getAllEndpoints() {
        List<Endpoint> endpoints = endpointService.findAll();
        if (endpoints.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(endpoints);
        }
    }

    @GetMapping("/endpoint/{id}")
    public ResponseEntity<Endpoint> getEndpointById(@PathVariable Long id) {
        Optional<Endpoint> endpoint = Optional.ofNullable(endpointService.findById(id));
        if (endpoint.isPresent()) {
            return ResponseEntity.ok(endpoint.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/endpoint", consumes = "application/json", produces = "application/json")
    public Endpoint createEndpoint(@RequestBody Endpoint endpoint) {

        API api = entityManager.getReference(API.class, endpoint.getApi().getId());
        endpoint.setApi(api);

        return endpointService.save(endpoint);
    }

    @PostMapping(value = "/endpoint/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Endpoint> updateEndpoint(@RequestBody Endpoint endpoint, @PathVariable Long id) {
        Optional<Endpoint> endpointOptional = Optional.ofNullable(endpointService.findById(id));
        if (endpointOptional.isPresent()) {
            endpointOptional.get().setUrl(endpoint.getUrl());
            endpointOptional.get().setHttpMethod(endpoint.getHttpMethod());
            endpointOptional.get().setApi(endpoint.getApi());
            endpointService.save(endpointOptional.get());
            return ResponseEntity.ok(endpointOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/endpoint/{id}")
    public ResponseEntity<Endpoint> deleteEndpoint(@PathVariable Long id) {
        Optional<Endpoint> endpoint = Optional.ofNullable(endpointService.findById(id));
        if (endpoint.isPresent()) {
            endpointService.deleteById(id);
            return ResponseEntity.ok(endpoint.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
