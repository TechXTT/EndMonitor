package me.bozhilov.EndMonitor.controller.resources;

import java.util.List;

import lombok.Data;

@Data
public class CompanyResource {

    private Long id;

    private String name;

    private String description;

    private List<UserResource> users;

    private List<APIResource> apis;

}
