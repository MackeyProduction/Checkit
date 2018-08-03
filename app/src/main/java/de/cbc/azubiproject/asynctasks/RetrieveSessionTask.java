package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.Collection;

import de.cbc.azubiproject.http.SessionResponse;

public class RetrieveSessionTask extends AsyncTask<SessionResponse, Void, Collection> {
    @Override
    protected Collection doInBackground(SessionResponse... sessionResponses) {
        return sessionResponses[0].getCollection();
    }
}
