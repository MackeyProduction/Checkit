package de.cbc.azubiproject.interfaces;

import org.json.JSONObject;

import java.util.Collection;

public interface IHttpRequest {
    public Collection<JSONObject> getRequest();
    public boolean postRequest(JSONObject data);
    public boolean deleteRequest();
}
