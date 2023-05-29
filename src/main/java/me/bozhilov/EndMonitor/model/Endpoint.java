package me.bozhilov.EndMonitor.model;

import jakarta.persistence.*;

@Entity
@Table(name = "endpoints")
public class Endpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    private String description;

    @ManyToOne
    @JoinColumn(name = "api_id", referencedColumnName = "id")
    private API api;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HttpMethod httpMethod;
}