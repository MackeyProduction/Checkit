package de.cbc.azubiproject.models;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IUserSession;

public class UserSession implements IUserSession {
    @Override
    public Collection<User> getUsers() {
        return null;
    }

    @Override
    public Collection<Session> getSessions() {
        return null;
    }
}
