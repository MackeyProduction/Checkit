package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.Collection;

import de.cbc.azubiproject.http.GroupResponse;

public class RetrieveGroupTask extends AsyncTask<GroupResponse, Void, Collection> {
    @Override
    protected Collection doInBackground(GroupResponse... groupResponses) {
        return groupResponses[0].getCollection();
    }
}
