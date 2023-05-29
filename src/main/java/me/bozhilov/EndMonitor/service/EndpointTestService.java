package me.bozhilov.EndMonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.bozhilov.EndMonitor.model.EndpointTest;
import me.bozhilov.EndMonitor.repository.EndpointTestRepository;

@Service
public class EndpointTestService {

    @Autowired
    private EndpointTestRepository endpointTestRepository;

    public List<EndpointTest> findAll() {
        return endpointTestRepository.findAll();
    }

    public EndpointTest findById(Long id) {
        return endpointTestRepository.findById(id).orElse(null);
    }

    public EndpointTest save(EndpointTest endpointTest) {
        return endpointTestRepository.save(endpointTest);
    }

    public void deleteById(Long id) {
        endpointTestRepository.deleteById(id);
    }
}
