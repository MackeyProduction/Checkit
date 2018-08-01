package de.cbc.azubiproject.http;

import de.cbc.azubiproject.interfaces.IEndpoint;

public class Endpoint implements IEndpoint {
    private final String ENDPOINT = "http://ec2st-ec2lo-1xf63if1n4t6d-1427651056.eu-west-1.elb.amazonaws.com/";
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
