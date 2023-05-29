package me.bozhilov.EndMonitor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import me.bozhilov.EndMonitor.model.API;
import me.bozhilov.EndMonitor.model.Endpoint;
import me.bozhilov.EndMonitor.model.EndpointTest;
import me.bozhilov.EndMonitor.service.EndpointTestService;

@RestController
public class EndpointTestController {

    @Autowired
    private EndpointTestService endpointTestService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/endpointTests")
    public ResponseEntity<List<EndpointTest>> getAllEndpointTests() {
        List<EndpointTest> endpointTests = endpointTestService.findAll();
        if (endpointTests.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(endpointTests);
        }
    }

    @GetMapping("/endpointTest/{id}")
    public ResponseEntity<EndpointTest> getEndpointTestById(@PathVariable Long id) {
        Optional<EndpointTest> endpointTest = Optional.ofNullable(endpointTestService.findById(id));
        if (endpointTest.isPresent()) {
            return ResponseEntity.ok(endpointTest.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/endpointTest", consumes = "application/json", produces = "application/json")
    public EndpointTest createEndpointTest(@RequestBody EndpointTest endpointTest) {

        Endpoint endpoint = entityManager.getReference(Endpoint.class, endpointTest.getEndpoint().getId());
        endpointTest.setEndpoint(endpoint);

        return endpointTestService.save(endpointTest);
    }

    @PostMapping(value = "/endpointTest/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EndpointTest> updateEndpointTest(@RequestBody EndpointTest endpointTest,
            @PathVariable Long id) {
        Optional<EndpointTest> endpointTestOptional = Optional.ofNullable(endpointTestService.findById(id));
        if (endpointTestOptional.isPresent()) {
            EndpointTest endpointTestToUpdate = endpointTestOptional.get();
            endpointTestToUpdate.setEndpoint(endpointTest.getEndpoint());
            endpointTestToUpdate.setRequestBody(endpointTest.getRequestBody());
            endpointTestToUpdate.setRequestHeaders(endpointTest.getRequestHeaders());
            endpointTestToUpdate.setRequestParams(endpointTest.getRequestParams());
            endpointTestToUpdate.setResponseHeaders(endpointTest.getResponseHeaders());
            endpointTestToUpdate.setResponseBody(endpointTest.getResponseBody());
            endpointTestService.save(endpointTestToUpdate);
            return ResponseEntity.ok(endpointTestToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
