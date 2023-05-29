package me.bozhilov.EndMonitor.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
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

    public Long getId() {
        return id;
    }

    public String getRoute() {
        return route;
    }

    public String getDescription() {
        return description;
    }

    public Company getCompany() {
        return company;
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }
}
