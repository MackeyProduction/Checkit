package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.models.Profile;
import de.cbc.azubiproject.models.User;

public class UserRegisterTask extends AsyncTask<User, Void, HttpResponse> {
    @Override
    protected HttpResponse doInBackground(User... users) {
        String json = String.format("{\"username\":\"%s\",\"password\":\"%s\",\"firstname\":\"%s\",\"lastname\":\"%s\",\"email\":\"%s\",\"birthDate\":\"%s\"}", users[0].getUsername(), users[0].getPassword(), users[0].getProfile().getFirstName(), users[0].getProfile().getLastName(), users[0].getProfile().getEmail(), users[0].getProfile().getBirthDate());
        return new HttpRequest(new Endpoint("/register.php")).postRequest(json);
    }
}
