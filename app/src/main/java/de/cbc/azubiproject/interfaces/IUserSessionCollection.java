package de.cbc.azubiproject.interfaces;

import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.repositories.SessionRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public interface IUserSessionCollection {
    public UserRepository getUserRepository() throws ExecutionException, InterruptedException;
    public SessionRepository getSessionRepository() throws ExecutionException, InterruptedException;
}
