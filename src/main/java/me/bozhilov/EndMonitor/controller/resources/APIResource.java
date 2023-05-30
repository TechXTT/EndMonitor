package me.bozhilov.EndMonitor.controller.resources;

import lombok.Data;

@Data
public class APIResource {

    private Long id;

    private String route;

    private String description;

    private String company;

}
