package de.cbc.azubiproject.http;

import de.cbc.azubiproject.interfaces.IEndpoint;

public class Endpoint implements IEndpoint {
    private final String ENDPOINT = "http://127.0.0.1/checkit-api";
    private String endpoint, key;

    public Endpoint(String endpoint)
    {
        this(endpoint, "");
    }

    public Endpoint(String endpoint, String key)
    {
        this.endpoint = ENDPOINT + endpoint;
        this.key = key;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }

    @Override
    public String getKey() {
        return key;
    }
}
