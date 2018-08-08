package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;

public class AddUserGroupTask extends AsyncTask<String, Void, HttpResponse> {
    @Override
    protected HttpResponse doInBackground(String... strings) {
        String json = String.format("{\"username\":\"%s\",\"groupName\":\"%s\",\"created\":\"%s\"}", strings[0], strings[1], strings[2]);
        return new HttpRequest(new Endpoint("/userGroups.php")).postRequest(json);
    }
}
