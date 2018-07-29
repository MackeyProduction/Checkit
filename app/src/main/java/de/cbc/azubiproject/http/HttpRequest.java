package de.cbc.azubiproject.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import de.cbc.azubiproject.interfaces.IHttpRequest;

public class HttpRequest implements IHttpRequest {
    private Endpoint endpoint;
    private URLConnection request;

    private JsonParser jsonParser = null;
    private JsonElement jsonElement = null;
    private JsonObject jsonObject = null;

    public HttpRequest(Endpoint endpoint) {
        this.endpoint = endpoint;
        this.jsonParser = new JsonParser();
    }

    @Override
    public JsonObject getRequest() {
        try {
            request = openConnection("GET");
            request.setDoInput(true);

            // Convert to a JSON object to print data
            jsonElement = jsonParser.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
            jsonObject = jsonElement.getAsJsonObject(); //May be an array, may be an object.
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    @Override
    public boolean postRequest(JsonObject data) {
        try {
            URL url = new URL(endpoint.getEndpoint());
            HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
            request.setRequestMethod("POST");
            request.setDoOutput(true);
            request.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(request.getOutputStream());

            // write output in output stream
            dataOutputStream.writeBytes(data.getAsString());
            dataOutputStream.flush();
            dataOutputStream.close();

            // status ok?
            if (request.getResponseCode() == 200) {
                return true;
            }

            //jsonParser.parse(data.getAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteRequest() {
        try {
            request = openConnection("DELETE");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private HttpsURLConnection openConnection(String method) throws IOException {
        URL url = new URL(endpoint.getEndpoint());
        HttpsURLConnection request = (HttpsURLConnection) url.openConnection();
        request.setRequestMethod(method);
        request.connect();

        return request;
    }
}
