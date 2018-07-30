package de.cbc.azubiproject.interfaces;

import de.cbc.azubiproject.repositories.SessionRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public interface IUserSessionCollection {
    public UserRepository getUserRepository();
    public SessionRepository getSessionRepository();
}
