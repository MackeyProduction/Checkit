package de.cbc.azubiproject.tests;

import com.google.gson.Gson;

import java.util.Date;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.models.Profile;
import de.cbc.azubiproject.models.User;

public class Register {
    public static void main(String[] args) {
        String username = "bigus";
        String password = "123456";
        String firstName = "David";
        String lastName = "Bigus";
        String email = "david.bigus@cbc.de";
        String birthDate = "1991-01-01";

        String json = String.format("{\"username\":\"%s\",\"password\":\"%s\",\"firstname\":\"%s\",\"lastname\":\"%s\",\"email\":\"%s\",\"birthDate\":\"%s\"}", username, password, firstName, lastName, email, birthDate);
        HttpResponse httpResponse = new HttpRequest(new Endpoint("/register.php")).postRequest(json);
        int statusCode = Integer.parseInt(httpResponse.getStatusCode());

        System.out.println(statusCode);
        System.out.println(httpResponse.getResponse() != null);
    }
}
