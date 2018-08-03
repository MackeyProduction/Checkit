package de.cbc.azubiproject.collections;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.interfaces.IUserSessionCollection;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserSession;
import de.cbc.azubiproject.repositories.SessionRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public class UserSessionCollection implements IUserSessionCollection {
    public UserSessionCollection() {
    }

    public UserRepository getUserRepository() throws ExecutionException, InterruptedException {
        return (UserRepository) UserRepository.getInstance();
    }

    public SessionRepository getSessionRepository() throws ExecutionException, InterruptedException {
        return (SessionRepository) SessionRepository.getInstance();
    }
}
