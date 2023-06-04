package me.bozhilov.EndMonitor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import me.bozhilov.EndMonitor.controller.resources.EndpointTestResource;
import me.bozhilov.EndMonitor.model.EndpointTest;
import me.bozhilov.EndMonitor.service.EndpointTestService;

@RestController
public class EndpointTestController {

    @Autowired
    private EndpointTestService endpointTestService;

    @GetMapping("/endpointtests")
    public ResponseEntity<List<EndpointTestResource>> getAllEndpointTests() {
        List<EndpointTestResource> endpointTests = endpointTestService.findAll();
        if (endpointTests.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(endpointTests);
        }
    }

    @GetMapping("/endpointtest/{id}")
    public ResponseEntity<EndpointTestResource> getEndpointTestById(@PathVariable Long id) {
        Optional<EndpointTestResource> endpointTest = endpointTestService.findById(id);
        if (endpointTest.isPresent()) {
            return ResponseEntity.ok(endpointTest.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/endpointtest", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EndpointTest> createEndpointTest(@RequestBody EndpointTestResource endpointTestResource) {
        EndpointTest endpointTest = endpointTestService.save(endpointTestResource);
        if (endpointTest != null) {
            return ResponseEntity.ok(endpointTest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/endpointtest/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<EndpointTest> updateEndpointTest(@RequestBody EndpointTestResource endpointTestResource,
            @PathVariable Long id) {
        // pass EndpointTestResource and id to update method
        EndpointTest endpointTest = endpointTestService.update(endpointTestResource, id);
        if (endpointTest != null) {
            return ResponseEntity.ok(endpointTest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/endpointtest/{id}")
    public ResponseEntity<EndpointTest> deleteEndpointTest(@PathVariable Long id) {
        Optional<EndpointTestResource> endpointTest = endpointTestService.findById(id);
        if (endpointTest.isPresent()) {
            endpointTestService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
