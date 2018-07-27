package de.cbc.azubiproject.models;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IUserSession;

public class UserSession implements IUserSession {
    private Collection<User> userCollection;
    private Collection<Session> sessionCollection;

    public UserSession(Collection<User> userCollection, Collection<Session> sessionCollection)
    {
        this.userCollection = userCollection;
        this.sessionCollection = sessionCollection;
    }

    @Override
    public Collection<User> getUsers() {
        return userCollection;
    }

    @Override
    public Collection<Session> getSessions() {
        return sessionCollection;
    }
}
