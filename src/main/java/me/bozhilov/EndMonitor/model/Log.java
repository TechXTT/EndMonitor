package me.bozhilov.EndMonitor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "endpoint_test_id", referencedColumnName = "id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private EndpointTest endpointTest;

    private String requestBody;

    private String requestHeaders;

    private String requestParams;

    private String responseBody;

    private String responseHeaders;

    private String responseStatusCode;
}
