package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.Collection;

import de.cbc.azubiproject.http.QuestionAnswerResponse;

public class RetrieveQuestionAnswerTask extends AsyncTask<QuestionAnswerResponse, Void, Collection> {
    @Override
    protected Collection doInBackground(QuestionAnswerResponse... questionAnswerResponses) {
        return (questionAnswerResponses[0] != null) ? questionAnswerResponses[0].getCollection() : questionAnswerResponses[0].getCollection();
    }
}
