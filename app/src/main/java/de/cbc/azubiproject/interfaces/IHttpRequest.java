package de.cbc.azubiproject.interfaces;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Collection;

public interface IHttpRequest {
    public JsonObject getRequest();
    public boolean postRequest(JsonObject data);
    public boolean deleteRequest();
}
