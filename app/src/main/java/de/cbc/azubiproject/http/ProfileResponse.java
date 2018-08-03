package de.cbc.azubiproject.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.cbc.azubiproject.interfaces.AbstractHttpResponse;
import de.cbc.azubiproject.interfaces.IHttpRequest;
import de.cbc.azubiproject.models.Profile;

public class ProfileResponse extends AbstractHttpResponse {
    public ProfileResponse(IHttpRequest request, Collection collection) {
        super(request, collection);
    }

    @Override
    protected Collection parse(HttpResponse httpResponse, Collection container) {
        Gson gson = new Gson();

        List<Profile> responseList = (ArrayList<Profile>)httpResponse.getResponse();
        String response = gson.toJson(responseList);
        Collection<Profile> users = gson.fromJson(response, new TypeToken<List<Profile>>(){}.getType());

        return users;
    }
}
