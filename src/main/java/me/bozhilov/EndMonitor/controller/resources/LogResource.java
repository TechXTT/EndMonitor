package me.bozhilov.EndMonitor.controller.resources;

import lombok.Data;

@Data
public class LogResource {

    private Long id;

    private Long endpointTestId;

    private String requestBody;

    private String requestHeaders;

    private String requestParams;

    private String responseBody;

    private String responseHeaders;

    private String responseStatusCode;
}
