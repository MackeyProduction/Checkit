package de.cbc.azubiproject.collections;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IUserSessionCollection;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserSession;
import de.cbc.azubiproject.repositories.SessionRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public class UserSessionCollection implements IUserSessionCollection {
    private Collection<UserSession> userSessionCollection;

    public UserSessionCollection(Collection<UserSession> userSessionCollection)
    {
        this.userSessionCollection = userSessionCollection;
    }

    public UserRepository getUserRepository()
    {
        return new UserRepository(new FilterCollection(userSessionCollection, userSession -> userSession.getUser().getUserId() > 0).getCollection());
    }

    public SessionRepository getSessionRepository()
    {
        return new SessionRepository(new FilterCollection(userSessionCollection, userSession -> userSession.getSession().getSId() > 0).getCollection());
    }
}
