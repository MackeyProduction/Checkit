package de.cbc.azubiproject.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;

public class Profile {
    public static void main(String[] args) {
        Gson gson = new Gson();

        HttpResponse httpResponse = new HttpRequest(new Endpoint("/userGroups.php?groups=anheier")).getRequest();
        String response = gson.toJson(httpResponse.getResponse());
        JsonElement element = gson.fromJson(response, JsonElement.class);
        String total = element.getAsJsonArray().get(0).getAsJsonObject().get("total").getAsString();

        System.out.println(response);
        System.out.println(total);
    }
}
