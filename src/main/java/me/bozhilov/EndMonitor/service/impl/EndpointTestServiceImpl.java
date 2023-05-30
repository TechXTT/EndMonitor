package me.bozhilov.EndMonitor.service.impl;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.bozhilov.EndMonitor.controller.resources.EndpointTestResource;
import me.bozhilov.EndMonitor.model.EndpointTest;
import me.bozhilov.EndMonitor.repository.EndpointTestRepository;
import me.bozhilov.EndMonitor.service.EndpointService;
import me.bozhilov.EndMonitor.service.EndpointTestService;

import static me.bozhilov.EndMonitor.mapper.EndpointTestMapper.endpointTestMapper;
import static me.bozhilov.EndMonitor.mapper.EndpointMapper.endpointMapper;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EndpointTestServiceImpl implements EndpointTestService {

    private final EndpointTestRepository endpointTestRepository;
    private final EndpointService endpointService;

    @Override
    public List<EndpointTestResource> findAll() {
        return endpointTestMapper.toEndpointTestResourceList(endpointTestRepository.findAll());
    }

    @Override
    public Optional<EndpointTestResource> findById(Long id) {
        return Optional.ofNullable(
                endpointTestMapper.toEndpointTestResource(endpointTestRepository.findById(id).orElse(null)));
    }

    @Override
    public EndpointTest save(EndpointTestResource endpointTestResource) {
        EndpointTest endpointTest = endpointTestMapper.fromEndpointTestResource(endpointTestResource);
        endpointService.findById(endpointTest.getEndpoint().getId())
                .ifPresentOrElse(
                        endpoint -> endpointTest.setEndpoint(endpointMapper.fromEndpointResource(endpoint)),
                        () -> {
                            throw new EntityNotFoundException(
                                    "Endpoint with id " + endpointTest.getEndpoint().getId() + " not found");
                        });
        return endpointTestRepository.save(endpointTest);
    }
}
