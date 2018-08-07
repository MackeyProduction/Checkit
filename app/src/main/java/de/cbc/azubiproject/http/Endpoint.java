package de.cbc.azubiproject.http;

import de.cbc.azubiproject.interfaces.IEndpoint;

public class Endpoint implements IEndpoint {
    private final String ENDPOINT = "http://EC2St-EC2Lo-2AWO0SV3URUG-1555616617.eu-west-1.elb.amazonaws.com/files";
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
