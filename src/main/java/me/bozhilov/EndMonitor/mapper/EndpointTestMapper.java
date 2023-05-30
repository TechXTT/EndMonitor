package me.bozhilov.EndMonitor.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import me.bozhilov.EndMonitor.controller.resources.EndpointTestResource;
import me.bozhilov.EndMonitor.model.EndpointTest;

@Mapper
public interface EndpointTestMapper {

    EndpointTestMapper endpointTestMapper = Mappers.getMapper(EndpointTestMapper.class);

    @Mapping(target = "endpoint.id", source = "endpointTestResource.endpoint")
    EndpointTest fromEndpointTestResource(EndpointTestResource endpointTestResource);

    @Mapping(target = "endpoint", source = "endpointTest.endpoint.id")
    EndpointTestResource toEndpointTestResource(EndpointTest endpointTest);

    List<EndpointTestResource> toEndpointTestResourceList(List<EndpointTest> endpointTests);
}
