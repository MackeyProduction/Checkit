package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.Collection;

import de.cbc.azubiproject.http.UserSessionResponse;

public class RetrieveUserSessionTask extends AsyncTask<UserSessionResponse, Void, Collection> {
    @Override
    protected Collection doInBackground(UserSessionResponse... userSessionResponses) {
        return userSessionResponses[0].getCollection();
    }
}
