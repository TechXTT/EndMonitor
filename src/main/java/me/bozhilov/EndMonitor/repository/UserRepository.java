package me.bozhilov.EndMonitor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import me.bozhilov.EndMonitor.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

}
