package de.cbc.azubiproject.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.cbc.azubiproject.interfaces.AbstractHttpResponse;
import de.cbc.azubiproject.interfaces.IHttpRequest;
import de.cbc.azubiproject.models.Session;

public class SessionResponse extends AbstractHttpResponse {
    public SessionResponse(IHttpRequest request, Collection collection) {
        super(request, collection);
    }

    @Override
    protected Collection parse(HttpResponse httpResponse, Collection container) {
        Gson gson = new Gson();

        List<Session> responseList = (ArrayList<Session>)httpResponse.getResponse();
        String response = gson.toJson(responseList);
        Collection<Session> sessions = gson.fromJson(response, new TypeToken<List<Session>>(){}.getType());

        return sessions;
    }
}
