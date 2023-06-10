package me.bozhilov.EndMonitor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import me.bozhilov.EndMonitor.controller.resources.LogResource;
import me.bozhilov.EndMonitor.model.Log;
import me.bozhilov.EndMonitor.service.LogService;

@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/v1/logs")
    public ResponseEntity<List<LogResource>> getAllLogs() {
        List<LogResource> logs = logService.findAll();
        if (logs.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(logs);
        }
    }

    @GetMapping("/v1/log/{id}")
    public ResponseEntity<LogResource> getLogById(@PathVariable Long id) {
        Optional<LogResource> log = logService.findById(id);
        if (log.isPresent()) {
            return ResponseEntity.ok(log.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/v1/log/{id}")
    public ResponseEntity<Log> deleteLog(@PathVariable Long id) {
        Optional<LogResource> log = logService.findById(id);
        if (log.isPresent()) {
            logService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
