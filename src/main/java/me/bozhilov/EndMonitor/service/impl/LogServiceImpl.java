package me.bozhilov.EndMonitor.service.impl;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.bozhilov.EndMonitor.controller.resources.LogResource;
import me.bozhilov.EndMonitor.model.Log;
import me.bozhilov.EndMonitor.repository.LogRepository;
import me.bozhilov.EndMonitor.service.EndpointTestService;
import me.bozhilov.EndMonitor.service.LogService;

import static me.bozhilov.EndMonitor.mapper.LogMapper.logMapper;
import static me.bozhilov.EndMonitor.mapper.EndpointTestMapper.endpointTestMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final EndpointTestService endpointTestService;

    @Override
    public List<LogResource> findAll() {
        return logMapper.toLogResourceList(logRepository.findAll());
    }

    @Override
    public Optional<LogResource> findById(Long id) {
        return Optional.ofNullable(
                logMapper.toLogResource(logRepository.findById(id).orElse(null)));
    }

    @Override
    public Log save(LogResource logResource) {
        Log log = logMapper.fromLogResource(logResource);
        endpointTestService.findById(log.getEndpointTest().getId())
                .ifPresentOrElse(
                        endpointTest -> log.setEndpointTest(endpointTestMapper.fromEndpointTestResource(endpointTest)),
                        () -> {
                            throw new EntityNotFoundException(
                                    "EndpointTest with id " + log.getEndpointTest().getId() + " not found");
                        });
        return logRepository.save(log);
    }
}
