package me.bozhilov.EndMonitor.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import me.bozhilov.EndMonitor.controller.resources.APIResource;
import me.bozhilov.EndMonitor.model.API;

@Mapper(uses = { EndpointMapper.class })
public interface APIMapper {

    APIMapper apiMapper = Mappers.getMapper(APIMapper.class);

    @Mapping(target = "company.name", source = "apiResource.company")
    API fromAPIResource(APIResource apiResource);

    @Mapping(target = "company", source = "api.company.name")
    APIResource toAPIResource(API api);

    List<APIResource> toAPIResourceList(List<API> apis);
}
