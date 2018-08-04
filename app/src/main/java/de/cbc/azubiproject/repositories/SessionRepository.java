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
    private static SessionRepository sessionRepository = null;

    private SessionRepository(Collection<Session> sessions) {
        sessionCollection = sessions;
    }

    public static SessionRepository getInstance() throws ExecutionException, InterruptedException {
        if (sessionRepository == null) {
            sessionRepository = new SessionRepository(new RetrieveSessionTask().execute(new SessionResponse(new HttpRequest(new Endpoint("/sessions.php")), sessionCollection)).get());
        }
        return sessionRepository;
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
