package de.cbc.azubiproject.interfaces;

import java.util.Collection;

import de.cbc.azubiproject.models.Session;
import de.cbc.azubiproject.models.User;

public interface IUserSession {
    public int getUserSessionId();
    public User getUser();
    public Session getSession();
}
