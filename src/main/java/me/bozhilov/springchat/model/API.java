package me.bozhilov.springchat.model;

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
    private Company company;    
}
