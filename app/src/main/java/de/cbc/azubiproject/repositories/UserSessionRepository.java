package de.cbc.azubiproject.repositories;

import java.util.Collection;

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
        return null;
    }

    @Override
    public Collection getAll() {
        return null;
    }
}
