package me.bozhilov.EndMonitor.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "apis")
public class API {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String route;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Company company;

    @OneToMany(mappedBy = "api")
    private List<Endpoint> endpoints;
}
