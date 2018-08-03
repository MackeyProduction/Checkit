package de.cbc.azubiproject.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.RetrieveUserSessionTask;
import de.cbc.azubiproject.collections.UserSessionCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.UserSessionResponse;
import de.cbc.azubiproject.models.UserSession;
import de.cbc.azubiproject.repositories.UserSessionRepository;

public interface IUserSessionRepository extends IResponseRepository {
    Collection<UserSession> userSessionCollection = null;

    public Collection<UserSession> getByUserId(int id);
    public boolean login(String username, String password) throws InterruptedException, ExecutionException;
    public boolean register(IUser user, IProfile profile) throws InterruptedException, ExecutionException;
    public boolean isSessionActive(String username) throws InterruptedException, ExecutionException;
}
