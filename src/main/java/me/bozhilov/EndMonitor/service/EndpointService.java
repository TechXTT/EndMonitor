package me.bozhilov.EndMonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.bozhilov.EndMonitor.repository.EndpointRepository;
import me.bozhilov.EndMonitor.model.Endpoint;

@Service
public class EndpointService {

    @Autowired
    private EndpointRepository endpointRepository;

    public EndpointService(EndpointRepository endpointRepository) {
        this.endpointRepository = endpointRepository;
    }

    public List<Endpoint> findAll() {
        return endpointRepository.findAll();
    }

    public Endpoint findById(Long id) {
        return endpointRepository.findById(id).orElse(null);
    }

    public Endpoint save(Endpoint endpoint) {
        return endpointRepository.save(endpoint);
    }

    public void deleteById(Long id) {
        endpointRepository.deleteById(id);
    }

}
