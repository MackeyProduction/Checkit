package de.cbc.azubiproject.interfaces;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.http.HttpResponse;

public interface IHttpRequest {
    public HttpResponse getRequest();
    public HttpResponse postRequest(String json);
    public HttpResponse deleteRequest(int id);
}
