package me.bozhilov.EndMonitor.service;

import java.util.List;
import java.util.Optional;

import me.bozhilov.EndMonitor.controller.resources.UserResource;
import me.bozhilov.EndMonitor.model.User;

public interface UserService {

    List<UserResource> findAll();

    Optional<UserResource> findById(Long id);

    User save(UserResource userResource);

    User update(UserResource userResource, Long id);

    void deleteById(Long id);

}
