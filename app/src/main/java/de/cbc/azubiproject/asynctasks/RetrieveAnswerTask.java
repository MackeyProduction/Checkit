package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.Collection;

import de.cbc.azubiproject.http.AnswerResponse;

public class RetrieveAnswerTask extends AsyncTask<AnswerResponse, Void, Collection> {
    @Override
    protected Collection doInBackground(AnswerResponse... answerResponses) {
        return answerResponses[0].getCollection();
    }
}
