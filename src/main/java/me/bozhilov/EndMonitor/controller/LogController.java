package me.bozhilov.EndMonitor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import me.bozhilov.EndMonitor.model.EndpointTest;
import me.bozhilov.EndMonitor.model.Log;
import me.bozhilov.EndMonitor.service.LogService;

@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/logs")
    public ResponseEntity<List<Log>> getAllLogs() {
        List<Log> logs = logService.findAll();
        if (logs.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(logs);
        }
    }

    @GetMapping("/log/{id}")
    public ResponseEntity<Log> getLogById(@PathVariable Long id) {
        Optional<Log> log = Optional.ofNullable(logService.findById(id));
        if (log.isPresent()) {
            return ResponseEntity.ok(log.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/log", consumes = "application/json", produces = "application/json")
    public Log createLog(Log log) {

        EndpointTest endpointTest = entityManager.getReference(EndpointTest.class, log.getEndpointTest().getId());
        log.setEndpointTest(endpointTest);

        return logService.save(log);
    }

    @PostMapping(value = "/log/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Log> updateLog(Log log, @PathVariable Long id) {
        Optional<Log> logOptional = Optional.ofNullable(logService.findById(id));
        if (logOptional.isPresent()) {
            Log logToUpdate = logOptional.get();
            logToUpdate.setEndpointTest(log.getEndpointTest());
            logToUpdate.setRequestBody(log.getRequestBody());
            logToUpdate.setRequestHeaders(log.getRequestHeaders());
            logToUpdate.setRequestParams(log.getRequestParams());
            logToUpdate.setResponseBody(log.getResponseBody());
            logToUpdate.setResponseHeaders(log.getResponseHeaders());
            logToUpdate.setResponseStatusCode(log.getResponseStatusCode());
            logService.save(logToUpdate);
            return ResponseEntity.ok(logToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/log/{id}")
    public ResponseEntity<Log> deleteLog(@PathVariable Long id) {
        Optional<Log> log = Optional.ofNullable(logService.findById(id));
        if (log.isPresent()) {
            logService.deleteById(id);
            return ResponseEntity.ok(log.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
