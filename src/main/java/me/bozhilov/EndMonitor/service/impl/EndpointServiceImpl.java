package me.bozhilov.EndMonitor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.bozhilov.EndMonitor.controller.resources.EndpointResource;
import me.bozhilov.EndMonitor.model.Endpoint;
import me.bozhilov.EndMonitor.repository.EndpointRepository;
import me.bozhilov.EndMonitor.service.APIService;
import me.bozhilov.EndMonitor.service.EndpointService;

import static me.bozhilov.EndMonitor.mapper.EndpointMapper.endpointMapper;
import static me.bozhilov.EndMonitor.mapper.APIMapper.apiMapper;

@Service
@RequiredArgsConstructor
public class EndpointServiceImpl implements EndpointService {

    private final EndpointRepository endpointRepository;
    private final APIService apiService;

    @Override
    public List<EndpointResource> findAll() {
        return endpointMapper.toEndpointResourceList(endpointRepository.findAll());
    }

    @Override
    public Optional<EndpointResource> findById(Long id) {
        return Optional.ofNullable(endpointMapper.toEndpointResource(endpointRepository.findById(id).orElse(null)));
    }

    @Override
    public Endpoint save(EndpointResource endpointResource) {
        Endpoint endpoint = endpointMapper.fromEndpointResource(endpointResource);
        apiService.findById(endpoint.getApi().getId())
                .ifPresentOrElse(
                        api -> endpoint.setApi(apiMapper.fromAPIResource(api)),
                        () -> {
                            throw new EntityNotFoundException(
                                    "API with id " + endpoint.getApi().getId() + " not found");
                        });
        return endpointRepository.save(endpoint);
    }

    @Override
    public Endpoint update(EndpointResource endpointResource, Long id) {
        Endpoint endpoint = endpointMapper.fromEndpointResource(endpointResource);
        endpoint.setId(id);
        apiService.findById(endpoint.getApi().getId())
                .ifPresentOrElse(
                        api -> endpoint.setApi(apiMapper.fromAPIResource(api)),
                        () -> {
                            throw new EntityNotFoundException(
                                    "API with id " + endpoint.getApi().getId() + " not found");
                        });
        return endpointRepository.save(endpoint);
    }

    @Override
    public void deleteById(Long id) {
        endpointRepository.deleteById(id);
    }
}
