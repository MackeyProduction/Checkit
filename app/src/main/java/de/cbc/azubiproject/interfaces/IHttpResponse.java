package de.cbc.azubiproject.interfaces;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.http.HttpRequest;

public interface IHttpResponse {
    public String getJson();
    public HttpRequest getRequest();
}
