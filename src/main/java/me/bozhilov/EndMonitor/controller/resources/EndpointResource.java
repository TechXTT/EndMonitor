package me.bozhilov.EndMonitor.controller.resources;

import java.util.List;

import lombok.Data;
import me.bozhilov.EndMonitor.model.HttpMethod;

@Data
public class EndpointResource {

    private Long id;

    private String url;

    private String description;

    private Long apiId;

    private HttpMethod method;

    private List<EndpointTestResource> endpointTests;
}
