package de.cbc.azubiproject.repositories;

import java.util.Collection;

import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.Session;

public class SessionRepository implements IRepository {
    private Collection<Session> sessionCollection;

    public SessionRepository(Collection<Session> sessionCollection)
    {
        this.sessionCollection = sessionCollection;
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
