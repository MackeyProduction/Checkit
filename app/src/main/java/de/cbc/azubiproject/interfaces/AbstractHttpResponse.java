package de.cbc.azubiproject.interfaces;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.http.HttpResponse;

public abstract class AbstractHttpResponse {
    private HttpResponse response;
    private Collection collection;

    public AbstractHttpResponse(HttpResponse response, Collection collection)
    {
        this.response = response;
        this.collection = collection;
    }

    public Collection getCollection()
    {
        return parse(response.getCollection(), collection);
    }

    protected abstract Collection parse(Collection<JSONObject> collection, Collection container);
}
