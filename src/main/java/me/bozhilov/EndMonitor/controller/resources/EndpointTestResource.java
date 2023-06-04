package me.bozhilov.EndMonitor.controller.resources;

import java.util.List;

import lombok.Data;

@Data
public class EndpointTestResource {

    private Long id;

    private String description;

    private Long endpointId;

    private String requestBody;

    private String requestHeaders;

    private String requestParams;

    private String responseBody;

    private String responseHeaders;

    private String responseStatusCode;

    private List<LogResource> logs;
}
