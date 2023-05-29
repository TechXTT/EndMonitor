package me.bozhilov.EndMonitor.model;

import jakarta.persistence.*;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "endpoint_test_id", referencedColumnName = "id")
    private EndpointTest endpointTest;

    private String requestBody;

    private String requestHeaders;

    private String requestParams;

    private String responseBody;

    private String responseHeaders;

    private String responseStatusCode;
}
