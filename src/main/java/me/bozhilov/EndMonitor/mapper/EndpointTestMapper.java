package me.bozhilov.EndMonitor.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import me.bozhilov.EndMonitor.controller.resources.EndpointTestResource;
import me.bozhilov.EndMonitor.model.EndpointTest;

@Mapper(uses = { LogMapper.class })
public interface EndpointTestMapper {

    EndpointTestMapper endpointTestMapper = Mappers.getMapper(EndpointTestMapper.class);

    @Mapping(target = "endpoint.id", source = "endpointTestResource.endpointId")
    EndpointTest fromEndpointTestResource(EndpointTestResource endpointTestResource);

    @Mapping(target = "endpointId", source = "endpointTest.endpoint.id")
    EndpointTestResource toEndpointTestResource(EndpointTest endpointTest);

    List<EndpointTestResource> toEndpointTestResourceList(List<EndpointTest> endpointTests);
}
