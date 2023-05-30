package me.bozhilov.EndMonitor.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "company")
    private List<User> users;
}