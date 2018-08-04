package de.cbc.azubiproject.http;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;

import de.cbc.azubiproject.interfaces.IHttpResponse;

public class HttpResponse implements IHttpResponse {
    private String responseCode;
    private Collection response;
    private Gson gson;

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
    public String getStatusMessage() {
        String responseMessage = "";
        gson = new Gson();

        try
        {
            String json = gson.toJson(new HttpResponse(this.responseCode, this.response), HttpResponse.class);
            JsonElement element = gson.fromJson(json, JsonElement.class);
            responseMessage = element.getAsJsonObject().get("response").getAsJsonArray().get(0).getAsJsonObject().get("responseMessage").getAsString();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        return responseMessage;
    }

    @Override
    public Collection getResponse() {
        return response;
    }
}
