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
import me.bozhilov.EndMonitor.model.API;
import me.bozhilov.EndMonitor.model.Company;
import me.bozhilov.EndMonitor.service.APIService;

@RestController
public class APIController {

    @Autowired
    private APIService apiService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/apis")
    public ResponseEntity<List<API>> getAllAPIs() {
        List<API> apis = apiService.findAll();
        if (apis.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(apis);
        }
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<API> getAPIById(Long id) {
        Optional<API> api = Optional.ofNullable(apiService.findById(id));
        if (api.isPresent()) {
            return ResponseEntity.ok(api.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/api", consumes = "application/json", produces = "application/json")
    public API createAPI(@RequestBody API api) {

        Company company = entityManager.getReference(Company.class, api.getCompany().getId());
        api.setCompany(company);

        return apiService.save(api);
    }

    @PostMapping(value = "/api/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<API> updateAPI(@RequestBody API api, @PathVariable Long id) {
        Optional<API> apiOptional = Optional.ofNullable(apiService.findById(id));
        if (apiOptional.isPresent()) {
            apiOptional.get().setRoute(api.getRoute());
            apiOptional.get().setDescription(api.getDescription());
            apiService.save(apiOptional.get());
            return ResponseEntity.ok(apiOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<API> deleteAPI(Long id) {
        Optional<API> api = Optional.ofNullable(apiService.findById(id));
        if (api.isPresent()) {
            apiService.deleteById(id);
            return ResponseEntity.ok(api.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
