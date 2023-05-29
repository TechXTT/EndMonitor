package me.bozhilov.EndMonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.bozhilov.EndMonitor.repository.LogRepository;
import me.bozhilov.EndMonitor.model.Log;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public Log findById(Long id) {
        return logRepository.findById(id).orElse(null);
    }

    public Log save(Log log) {
        return logRepository.save(log);
    }

    public void deleteById(Long id) {
        logRepository.deleteById(id);
    }

}
