package de.cbc.azubiproject.http;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Collection;

import de.cbc.azubiproject.interfaces.IHttpResponse;

public class HttpResponse implements IHttpResponse {
    private String responseCode;
    private Collection response;

    public HttpResponse(String responseCode, Collection response)
    {
        this.responseCode = responseCode;
        this.response = response;
    }

    @Override
    public String getStatusCode() {
        return responseCode;
    }

    @Override
    public Collection getResponse() {
        return response;
    }
}
