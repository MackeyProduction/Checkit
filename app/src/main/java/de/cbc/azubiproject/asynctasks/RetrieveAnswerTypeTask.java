package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.Collection;

import de.cbc.azubiproject.http.AnswerTypeResponse;
import de.cbc.azubiproject.http.ProfileResponse;

public class RetrieveAnswerTypeTask extends AsyncTask<AnswerTypeResponse, Void, Collection> {
    @Override
    protected Collection doInBackground(AnswerTypeResponse... answerTypeResponses) {
        return answerTypeResponses[0].getCollection();
    }
}
