package de.cbc.azubiproject.http;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IHttpResponse;

public class HttpResponse implements IHttpResponse {
    private HttpRequest request;
    private Collection<JSONObject> collection;

    public HttpResponse(HttpRequest request, Collection<JSONObject> collection)
    {
        this.request = request;
        this.collection = collection;
    }

    @Override
    public Collection<JSONObject> getCollection() {
        return null;
    }

    @Override
    public HttpRequest getRequest() {
        return null;
    }
}
