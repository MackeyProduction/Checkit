package de.cbc.azubiproject.interfaces;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.http.HttpResponse;

public abstract class AbstractHttpResponse {
    private HttpResponse response;

    public AbstractHttpResponse(HttpResponse response)
    {
        this.response = response;
    }

    public Collection<JSONObject> getCollection()
    {
        return null;
    }

    protected abstract Collection<JSONObject> parse(Collection<JSONObject> collection);
}
