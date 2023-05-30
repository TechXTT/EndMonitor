package me.bozhilov.EndMonitor.controller.resources;

import lombok.Data;

@Data
public class UserResource {

    private Long id;

    private String username;

    private String email;

    private String password;

    private String company;
}
