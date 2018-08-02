package de.cbc.azubiproject.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.AbstractHttpResponse;
import de.cbc.azubiproject.models.Group;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;

public class UserGroupResponse extends AbstractHttpResponse {
    public UserGroupResponse(HttpRequest httpRequest, Collection collection) {
        super(httpRequest, collection);
    }

    @Override
    protected Collection parse(HttpResponse httpResponse, Collection container) {
        Gson gson = new Gson();

        List<UserGroup> responseList = (ArrayList<UserGroup>)httpResponse.getResponse();
        String response = gson.toJson(responseList);
        Collection<UserGroup> userGroup = gson.fromJson(response, new TypeToken<List<UserGroup>>(){}.getType());

        return userGroup;
    }
}
