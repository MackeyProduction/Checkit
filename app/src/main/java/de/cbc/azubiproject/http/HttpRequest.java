package de.cbc.azubiproject.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;

import javax.net.ssl.HttpsURLConnection;

import de.cbc.azubiproject.interfaces.IHttpRequest;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http2.ConnectionShutdownException;

public class HttpRequest implements IHttpRequest {
    private Endpoint endpoint;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient client;
    private Gson gson;
    private HttpResponse validate, httpResponse;

    public HttpRequest(Endpoint endpoint) {
        this.endpoint = endpoint;
        this.client = new OkHttpClient();
        this.gson = new Gson();
    }

    @Override
    public HttpResponse getRequest() {
        try {
            Request request = new Request.Builder()
                    .url(endpoint.getEndpoint())
                    .build();

            Response response = client.newCall(request).execute();

            validate = validate(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return validate;
    }

    @Override
    public HttpResponse postRequest(String json) {
        try {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(endpoint.getEndpoint())
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();

            validate = validate(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return validate;
    }

    @Override
    public HttpResponse deleteRequest(int id) {
        try {
            HttpUrl route = HttpUrl.parse(endpoint.getEndpoint())
                    .newBuilder()
                    .addPathSegment(Integer.toString(id))
                    .build();
            Request request = new Request.Builder()
                    .url(route)
                    .delete()
                    .build();
            Response response = client.newCall(request).execute();

            validate = validate(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return validate;
    }

    private HttpResponse validate(Response response) {
        HttpResponse httpResponse = gson.fromJson("{'responseCode':'5001','response':[{'responseMessage':'Es konnte keine Verbindung zum Server aufgebaut werden.'}]}", HttpResponse.class);
        try {
            String responseString = response.body().string();
            if (responseString != null) {
                if (response.isSuccessful()) {
                    System.out.println("response: " + responseString);

                    if (!responseString.equals("") && !responseString.startsWith("<!DOCTYPE html>")) {
                        httpResponse = gson.fromJson(responseString, HttpResponse.class);
                    }
                } else {
                    if (!responseString.equals("")) {
                        JsonElement element = gson.fromJson(responseString, JsonElement.class);
                        System.out.println(element.getAsJsonObject().get("response"));
                        httpResponse = gson.fromJson(responseString, HttpResponse.class);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return httpResponse;
    }
}
