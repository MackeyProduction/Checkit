package de.cbc.azubiproject.repositories;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.RetrieveSessionTask;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.SessionResponse;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.Session;

public class SessionRepository implements IRepository {
    private static Collection<Session> sessionCollection = null;

    private SessionRepository() {
    }

    public static Collection<Session> getInstance() throws ExecutionException, InterruptedException {
        if (sessionCollection == null) {
            sessionCollection = (Collection<Session>) new RetrieveSessionTask().execute(new SessionResponse(new HttpRequest(new Endpoint("/sessions.php")), sessionCollection)).get();
        }
        return sessionCollection;
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(sessionCollection, session -> session.getSId() == id);
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(sessionCollection, session -> session.getSId() > 0).getCollection();
    }
}
