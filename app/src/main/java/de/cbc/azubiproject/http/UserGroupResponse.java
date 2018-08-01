package de.cbc.azubiproject.http;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.AbstractHttpResponse;
import de.cbc.azubiproject.models.UserGroup;

public class UserGroupResponse extends AbstractHttpResponse {
    public UserGroupResponse(HttpResponse response, Collection collection) {
        super(response, collection);
    }

    @Override
    protected Collection parse(String json, Collection container) {
        Gson gson = new Gson();
        gson.fromJson(json, UserGroup.class);

        return null;
    }
}
