package de.cbc.azubiproject.repositories;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.collections.UserSessionCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.http.UserSessionResponse;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.interfaces.IResponseRepository;
import de.cbc.azubiproject.interfaces.IUserSessionRepository;
import de.cbc.azubiproject.models.UserSession;

public class UserSessionRepository implements IUserSessionRepository {
    private Collection<UserSession> userSessionCollection;

    public UserSessionRepository(Collection<UserSession> userSessionCollection)
    {
        this.userSessionCollection = userSessionCollection;
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(userSessionCollection, userSession -> userSession.getUserSessionId() == id);
    }

    @Override
    public Collection getAll() {
        return new UserSessionResponse(new HttpResponse(new HttpRequest(new Endpoint("/sessions")), new ArrayList<JSONObject>()), new ArrayList<UserSession>()).getCollection();
    }

    @Override
    public Collection<UserSession> getByUserId(int id) {
        return new UserSessionResponse(new HttpResponse(new HttpRequest(new Endpoint("/login")), new ArrayList<JSONObject>()), new ArrayList<UserSession>()).getCollection();
    }

    @Override
    public UserSessionCollection getRepositories() {
        return null;
    }
}
