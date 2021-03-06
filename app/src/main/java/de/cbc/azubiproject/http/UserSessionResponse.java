package de.cbc.azubiproject.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.AbstractHttpResponse;
import de.cbc.azubiproject.interfaces.IHttpRequest;
import de.cbc.azubiproject.models.UserSession;

public class UserSessionResponse extends AbstractHttpResponse {
    public UserSessionResponse(IHttpRequest request, Collection collection) {
        super(request, collection);
    }

    @Override
    protected Collection parse(HttpResponse httpResponse, Collection container) {
        Gson gson = new Gson();

        List<UserSession> responseList = (ArrayList<UserSession>)httpResponse.getResponse();
        String response = gson.toJson(responseList);
        Collection<UserSession> userSessions = gson.fromJson(response, new TypeToken<List<UserSession>>(){}.getType());

        return userSessions;
    }
}
