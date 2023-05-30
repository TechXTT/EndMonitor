package me.bozhilov.EndMonitor.controller.resources;

import lombok.Data;

@Data
public class EndpointTestResource {

    private Long id;

    private String description;

    private String endpointId;

    private String requestBody;

    private String requestHeaders;

    private String requestParams;

    private String responseBody;

    private String responseHeaders;

    private String responseStatusCode;
}
