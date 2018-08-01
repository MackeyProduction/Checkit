package de.cbc.azubiproject.http;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.AbstractHttpResponse;

public class UserSessionResponse extends AbstractHttpResponse {
    public UserSessionResponse(HttpResponse response, Collection collection) {
        super(response, collection);
    }

    @Override
    protected Collection parse(String json, Collection container) {
        return null;
    }
}
