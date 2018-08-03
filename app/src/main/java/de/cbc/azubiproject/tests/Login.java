package de.cbc.azubiproject.tests;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;

public class Login {
    public static void main(String[] args) {
        String json = null;
        int statusCode = 0;

        String username = "anheier";
        String password = "foobar";

        json = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);
        HttpResponse httpResponse = new HttpRequest(new Endpoint("/login.php")).postRequest(json);
        statusCode = Integer.parseInt(httpResponse.getStatusCode());

        System.out.println(json);
        System.out.println(statusCode);
    }
}
