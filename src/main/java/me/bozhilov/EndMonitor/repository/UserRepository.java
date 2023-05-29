package me.bozhilov.EndMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.bozhilov.EndMonitor.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);

}
