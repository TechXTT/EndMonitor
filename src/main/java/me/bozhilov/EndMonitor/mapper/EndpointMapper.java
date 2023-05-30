package me.bozhilov.EndMonitor.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import me.bozhilov.EndMonitor.controller.resources.EndpointResource;
import me.bozhilov.EndMonitor.model.Endpoint;

@Mapper
public interface EndpointMapper {

    EndpointMapper endpointMapper = Mappers.getMapper(EndpointMapper.class);

    @Mapping(target = "api.id", source = "endpointResource.api")
    Endpoint fromEndpointResource(EndpointResource endpointResource);

    @Mapping(target = "api", source = "endpoint.api.id")
    EndpointResource toEndpointResource(Endpoint endpoint);

    List<EndpointResource> toEndpointResourceList(List<Endpoint> endpoints);
}
