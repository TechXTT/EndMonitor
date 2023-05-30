package me.bozhilov.EndMonitor.controller.resources;

import lombok.Data;
import me.bozhilov.EndMonitor.model.HttpMethod;

@Data
public class EndpointResource {

    private Long id;

    private String url;

    private String description;

    private String apiId;

    private HttpMethod method;
}
