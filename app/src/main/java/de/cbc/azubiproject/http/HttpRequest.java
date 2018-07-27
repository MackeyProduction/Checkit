package de.cbc.azubiproject.http;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IHttpRequest;

public class HttpRequest implements IHttpRequest {
    private Endpoint endpoint;

    public HttpRequest(Endpoint endpoint)
    {
        this.endpoint = endpoint;
    }

    @Override
    public Collection<JSONObject> getRequest() {
        return null;
    }

    @Override
    public boolean postRequest(JSONObject data) {
        return false;
    }

    @Override
    public boolean deleteRequest() {
        return false;
    }
}
