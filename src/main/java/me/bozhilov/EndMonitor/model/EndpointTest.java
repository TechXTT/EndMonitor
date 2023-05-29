package me.bozhilov.EndMonitor.model;

import jakarta.persistence.*;

@Entity
@Table(name = "endpoint_tests")
public class EndpointTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "endpoint_id", referencedColumnName = "id")
    private Endpoint endpoint;

    private String requestBody;

    private String requestHeaders;

    private String requestParams;

    private String responseBody;

    private String responseHeaders;

    private String responseStatusCode;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public String getDescription() {
        return description;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public String getRequestHeaders() {
        return requestHeaders;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public String getResponseHeaders() {
        return responseHeaders;
    }

    public String getResponseStatusCode() {
        return responseStatusCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public void setRequestHeaders(String requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public void setResponseHeaders(String responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public void setResponseStatusCode(String responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }

}
