package de.cbc.azubiproject.http;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IHttpResponse;

public class HttpResponse implements IHttpResponse {
    private HttpRequest request;
    private String json;

    public HttpResponse(HttpRequest request, String json)
    {
        this.request = request;
        this.json = json;
    }

    @Override
    public String getJson() {
        return json;
    }

    @Override
    public HttpRequest getRequest() {
        return request;
    }
}
