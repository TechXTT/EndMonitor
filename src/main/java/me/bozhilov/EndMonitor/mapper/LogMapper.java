package me.bozhilov.EndMonitor.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import me.bozhilov.EndMonitor.controller.resources.LogResource;
import me.bozhilov.EndMonitor.model.Log;

@Mapper
public interface LogMapper {

    LogMapper logMapper = Mappers.getMapper(LogMapper.class);

    @Mapping(target = "endpointTest.id", source = "logResource.endpointTest")
    Log fromLogResource(LogResource logResource);

    @Mapping(target = "endpointTest", source = "log.endpointTest.id")
    LogResource toLogResource(Log log);

    List<LogResource> toLogResourceList(List<Log> logs);
}
