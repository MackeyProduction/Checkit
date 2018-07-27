package de.cbc.azubiproject.repositories;

import java.util.Collection;

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
        return null;
    }

    @Override
    public <T> Collection<T> getAll() {
        return null;
    }
}
