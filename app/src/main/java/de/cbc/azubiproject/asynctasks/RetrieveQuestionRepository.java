package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.Collection;

import de.cbc.azubiproject.http.QuestionResponse;

public class RetrieveQuestionRepository extends AsyncTask<QuestionResponse, Void, Collection> {
    @Override
    protected Collection doInBackground(QuestionResponse... questionResponses) {
        return questionResponses[0].getCollection();
    }
}
