package de.cbc.azubiproject.http;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.AbstractHttpResponse;

public class UserGroupResponse extends AbstractHttpResponse {
    public UserGroupResponse(HttpResponse response, Collection collection) {
        super(response, collection);
    }

    @Override
    protected Collection parse(Collection<JSONObject> collection, Collection container) {
        return null;
    }
}
