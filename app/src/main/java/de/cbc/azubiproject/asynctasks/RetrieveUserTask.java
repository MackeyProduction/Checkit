package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.Collection;

import de.cbc.azubiproject.http.UserResponse;

public class RetrieveUserTask extends AsyncTask<UserResponse, Void, Collection> {
    @Override
    protected Collection doInBackground(UserResponse... userResponses) {
        return userResponses[0].getCollection();
    }
}
