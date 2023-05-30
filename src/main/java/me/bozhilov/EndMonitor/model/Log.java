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

    public Long getId() {
        return id;
    }

    public EndpointTest getEndpointTest() {
        return endpointTest;
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

    public void setEndpointTest(EndpointTest endpointTest) {
        this.endpointTest = endpointTest;
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
