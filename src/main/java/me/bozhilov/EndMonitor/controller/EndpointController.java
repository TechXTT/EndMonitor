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

import me.bozhilov.EndMonitor.service.EndpointService;
import me.bozhilov.EndMonitor.model.Endpoint;
import me.bozhilov.EndMonitor.controller.resources.EndpointResource;

@RestController
public class EndpointController {

    @Autowired
    private EndpointService endpointService;

    @GetMapping("/endpoints")
    public ResponseEntity<List<EndpointResource>> getAllEndpoints() {
        List<EndpointResource> endpoints = endpointService.findAll();
        if (endpoints.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(endpoints);
        }
    }

    @GetMapping("/endpoint/{id}")
    public ResponseEntity<EndpointResource> getEndpointById(@PathVariable Long id) {
        Optional<EndpointResource> endpoint = endpointService.findById(id);
        if (endpoint.isPresent()) {
            return ResponseEntity.ok(endpoint.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/endpoint", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Endpoint> createEndpoint(@RequestBody EndpointResource endpointResource) {
        Endpoint endpoint = endpointService.save(endpointResource);
        if (endpoint != null) {
            return ResponseEntity.ok(endpoint);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/endpoint/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Endpoint> updateEndpoint(@RequestBody EndpointResource endpointResource,
            @PathVariable Long id) {
        // pass EndpointResource and id to update method
        Endpoint endpoint = endpointService.update(endpointResource, id);
        if (endpoint != null) {
            return ResponseEntity.ok(endpoint);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/endpoint/{id}")
    public ResponseEntity<Endpoint> deleteEndpoint(@PathVariable Long id) {
        Optional<EndpointResource> endpoint = endpointService.findById(id);
        if (endpoint.isPresent()) {
            endpointService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
