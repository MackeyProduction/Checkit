package de.cbc.azubiproject.models;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IUserSession;

public class UserSession implements IUserSession {
    private int userSessionId;
    private User user;
    private Session session;

    public UserSession()
    {
        super();
    }

    public UserSession(int userSessionId, User user, Session session)
    {
        this.userSessionId = userSessionId;
        this.user = user;
        this.session = session;
    }

    @Override
    public int getUserSessionId() {
        return userSessionId;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Session getSession() {
        return session;
    }
}
