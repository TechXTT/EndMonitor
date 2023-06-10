package me.bozhilov.EndMonitor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.bozhilov.EndMonitor.controller.resources.APIResource;
import me.bozhilov.EndMonitor.model.API;
import me.bozhilov.EndMonitor.service.APIService;

@RestController
public class APIController {

    @Autowired
    private APIService apiService;

    @GetMapping("/apis")
    public ResponseEntity<List<APIResource>> getAllAPIs() {
        List<APIResource> apis = apiService.findAll();
        if (apis.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(apis);
        }
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<APIResource> getAPIById(@PathVariable Long id) {
        Optional<APIResource> api = apiService.findById(id);
        if (api.isPresent()) {
            return ResponseEntity.ok(api.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/api", consumes = "application/json", produces = "application/json")
    public ResponseEntity<API> createAPI(@RequestBody APIResource apiResource) {
        API api = apiService.save(apiResource);
        if (api != null) {
            return ResponseEntity.ok(api);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/api/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<API> updateAPI(@RequestBody APIResource apiResource, @PathVariable Long id) {
        API api = apiService.update(apiResource, id);
        if (api != null) {
            return ResponseEntity.ok(api);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<API> deleteAPI(@PathVariable Long id) {
        Optional<APIResource> api = apiService.findById(id);
        if (api.isPresent()) {
            apiService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
