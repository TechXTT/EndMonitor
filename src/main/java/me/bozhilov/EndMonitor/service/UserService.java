package me.bozhilov.EndMonitor.service;

import java.util.List;

import me.bozhilov.EndMonitor.controller.resources.UserResource;
import me.bozhilov.EndMonitor.model.User;

public interface UserService {

    List<UserResource> findAll();

    UserResource findById(Long id);

    User save(UserResource userResource);

}
