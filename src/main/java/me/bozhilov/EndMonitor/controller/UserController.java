package me.bozhilov.EndMonitor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.bozhilov.EndMonitor.model.User;
import me.bozhilov.EndMonitor.controller.resources.UserResource;
import me.bozhilov.EndMonitor.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResource>> getAllUsers() {
        List<UserResource> users = userService.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id) {
        Optional<UserResource> userResource = userService.findById(id);
        if (userResource != null) {
            return ResponseEntity.ok(userResource.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserResource userResource) {
        User user = userService.save(userResource);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        Optional<UserResource> userResource = userService.findById(id);
        if (userResource != null) {
            userService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @PostMapping("/user/login")
    // public ResponseEntity<User> loginUser(@RequestBody UserResource userResource)
    // {
    // User user = userService.findByUsername(userResource.getUsername());
    // if (user != null) {
    // if (BCrypt.checkpw(userResource.getPassword(), user.getPassword())) {
    // return ResponseEntity.ok(user);
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }

    // @PostMapping("/user/register")
    // public ResponseEntity<User> registerUser(@RequestBody UserResource
    // userResource) {
    // User user = userService.findByUsername(userResource.getUsername());
    // if (user == null) {
    // user = new User();
    // user.setUsername(userResource.getUsername());
    // user.setPassword(BCrypt.hashpw(userResource.getPassword(),
    // BCrypt.gensalt()));
    // user.setCompany(entityManager.find(Company.class,
    // userResource.getCompanyId()));
    // user = userService.save(user);
    // return ResponseEntity.ok(user);
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }

    // @PostMapping("/user/update")
    // public ResponseEntity<User> updateUser(@RequestBody UserResource
    // userResource) {
    // User user = userService.findByUsername(userResource.getUsername());
    // if (user != null) {
    // user.setUsername(userResource.getUsername());
    // user.setPassword(BCrypt.hashpw(userResource.getPassword(),
    // BCrypt.gensalt()));
    // user.setCompany(entityManager.find(Company.class,
    // userResource.getCompanyId()));
    // user = userService.save(user);
    // return ResponseEntity.ok(user);
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }
}
