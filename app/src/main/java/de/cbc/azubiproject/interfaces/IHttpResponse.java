package de.cbc.azubiproject.interfaces;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Collection;

import de.cbc.azubiproject.http.HttpRequest;

public interface IHttpResponse {
    String getStatusCode();
    Collection getResponse();
}
