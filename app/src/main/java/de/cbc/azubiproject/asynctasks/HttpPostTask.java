package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import de.cbc.azubiproject.http.HttpResponse;

public class HttpPostTask extends AsyncTask<HttpResponse, Void, Integer> {
    @Override
    protected Integer doInBackground(HttpResponse... httpResponses) {
        return Integer.parseInt(httpResponses[0].getStatusCode());
    }
}
