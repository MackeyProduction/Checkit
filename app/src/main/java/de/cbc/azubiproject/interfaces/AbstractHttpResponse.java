package de.cbc.azubiproject.interfaces;

import org.json.JSONObject;

import java.util.Collection;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.http.HttpResponse;

public abstract class AbstractHttpResponse {
    private IHttpRequest request;
    private Collection collection;

    public AbstractHttpResponse(IHttpRequest request, Collection collection)
    {
        this.request = request;
        this.collection = collection;
    }

    public Collection getCollection()
    {
        return parse(request.getRequest(), collection);
    }

    protected abstract Collection parse(HttpResponse httpResponse, Collection container);
}
