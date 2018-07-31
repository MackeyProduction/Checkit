package de.cbc.azubiproject.interfaces;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Collection;

public interface IHttpRequest {
    public String getRequest();
    public boolean postRequest(String json);
    public boolean deleteRequest(int id);
}
