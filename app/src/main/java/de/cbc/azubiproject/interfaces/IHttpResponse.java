package de.cbc.azubiproject.interfaces;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.http.HttpRequest;

public interface IHttpResponse {
    public Collection<JSONObject> getCollection();
    public HttpRequest getRequest();
}
