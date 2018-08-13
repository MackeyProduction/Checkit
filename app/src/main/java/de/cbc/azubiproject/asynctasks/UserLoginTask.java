package de.cbc.azubiproject.asynctasks;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;

public class UserLoginTask extends AsyncTask<String, Void, HttpResponse> {
    @Override
    protected HttpResponse doInBackground(String... strings) {
        String json = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", strings[0], strings[1]);
        return new HttpRequest(new Endpoint("/login.php")).postRequest(json);
    }
}
