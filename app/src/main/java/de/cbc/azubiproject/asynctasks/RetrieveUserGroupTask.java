package de.cbc.azubiproject.asynctasks;

import android.os.AsyncTask;

import java.util.Collection;

import de.cbc.azubiproject.http.UserGroupResponse;

public class RetrieveUserGroupTask extends AsyncTask<UserGroupResponse, Void, Collection> {
    @Override
    protected Collection doInBackground(UserGroupResponse... userGroupResponses) {
        return userGroupResponses[0].getCollection();
    }
}
