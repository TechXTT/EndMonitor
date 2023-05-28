-- Table: Users
CREATE TABLE Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    company_id INT REFERENCES Companies(id)
);

-- Table: Companies
CREATE TABLE Companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

-- Table: APIs
CREATE TABLE APIs (
    id SERIAL PRIMARY KEY,
    route VARCHAR(255) NOT NULL,
    description TEXT,
    company_id INT REFERENCES Companies(id)
);

-- Table: Endpoints
CREATE TABLE Endpoints (
    id SERIAL PRIMARY KEY,
    description TEXT,
    api_id INT REFERENCES APIs(id),
    url VARCHAR(255) NOT NULL,
    method VARCHAR(255) NOT NULL CHECK (method IN ('GET', 'POST', 'PUT', 'DELETE', 'PATCH'))
);

-- Table: EndpointTests
CREATE TABLE EndpointTests (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    endpoint_id INT REFERENCES Endpoints(id),
    request_body TEXT,
    request_headers TEXT,
    request_params TEXT,
    response_body TEXT,
    response_headers TEXT,
    response_status_code INT
);

-- Table: Logs
CREATE TABLE Logs (
    id SERIAL PRIMARY KEY,
    endpoint_test_id INT REFERENCES EndpointTests(id),
    request_body TEXT,
    request_headers TEXT,
    request_params TEXT,
    response_body TEXT,
    response_headers TEXT,
    response_status_code INT
);

-- Table: UserAPIs
CREATE TABLE UserAPIs (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES Users(id),
    api_id INT REFERENCES APIs(id)
);

-- Table: UserEndpoints
CREATE TABLE UserEndpoints (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES Users(id),
    endpoint_id INT REFERENCES Endpoints(id)
);
