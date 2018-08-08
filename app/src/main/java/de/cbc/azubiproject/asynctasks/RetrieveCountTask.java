package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.models.Profile;

public class RetrieveCountTask extends AsyncTask<HttpRequest, Void, String> {
    @Override
    protected String doInBackground(HttpRequest... httpRequests) {
        Gson gson = new Gson();

        String response = gson.toJson(httpRequests[0].getRequest().getResponse());
        JsonElement element = gson.fromJson(response, JsonElement.class);
        String total = element.getAsJsonArray().get(0).getAsJsonObject().get("total").getAsString();

        return total;
    }
}
