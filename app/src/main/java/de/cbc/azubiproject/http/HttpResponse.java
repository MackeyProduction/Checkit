package de.cbc.azubiproject.http;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IHttpResponse;

public class HttpResponse implements IHttpResponse {
    @Override
    public Collection<JSONObject> getCollection() {
        return null;
    }

    @Override
    public HttpRequest getRequest() {
        return null;
    }
}
