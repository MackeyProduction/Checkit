package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;

public class AddQuestionTask extends AsyncTask<String, Void, HttpResponse> {
    @Override
    protected HttpResponse doInBackground(String... strings) {
        String pattern = "(\\\"|\\'|\\\\|\\$)+";

        Pattern regEx = Pattern.compile(pattern);

        Matcher matchQuestion = regEx.matcher(strings[2]);
        Matcher matchAnswer = regEx.matcher(strings[3]);

        if (matchQuestion.find() || matchAnswer.find()) {
            strings[2] = strings[2].replaceAll(pattern, "");
            strings[3] = strings[3].replaceAll(pattern, "");
        }
        String json = String.format("{\"username\":\"%s\",\"groupName\":\"%s\",\"question\":\"%s\",\"answer\":\"%s\",\"answerType\":\"%s\",\"correct\":\"%s\"}", strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
        return new HttpRequest(new Endpoint("/questionAnswer.php")).postRequest(json);
    }
}
