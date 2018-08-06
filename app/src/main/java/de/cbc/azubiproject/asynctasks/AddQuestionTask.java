package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;

public class AddQuestionTask extends AsyncTask<String, Void, HttpResponse> {
    @Override
    protected HttpResponse doInBackground(String... strings) {
        String json = String.format("{\"username\":\"%s\",\"groupName\":\"%s\",\"question\":\"%s\",\"answer\":\"%s\",\"answerType\":\"%s\",\"correct\":\"%s\",\"createDate\":\"%s\"}", strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6], strings[7]);
        return new HttpRequest(new Endpoint("/questionAnswer.php")).postRequest(json);
    }
}
