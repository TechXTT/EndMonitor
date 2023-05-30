package me.bozhilov.EndMonitor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private API api;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HttpMethod httpMethod;

    @OneToMany(mappedBy = "endpoint")
    private List<EndpointTest> endpointTests;

}