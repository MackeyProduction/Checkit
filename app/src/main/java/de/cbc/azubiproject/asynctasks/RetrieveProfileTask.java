package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.Collection;

import de.cbc.azubiproject.http.ProfileResponse;

public class RetrieveProfileTask extends AsyncTask<ProfileResponse, Void, Collection> {
    @Override
    protected Collection doInBackground(ProfileResponse... profileResponses) {
        return profileResponses[0].getCollection();
    }
}
