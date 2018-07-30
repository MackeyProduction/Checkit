package de.cbc.azubiproject.interfaces;

import java.util.Collection;

import de.cbc.azubiproject.collections.UserSessionCollection;
import de.cbc.azubiproject.models.UserSession;

public interface IUserSessionRepository extends IResponseRepository {
    public Collection<UserSession> getByUserId(int id);
    public UserSessionCollection getRepositories();
}
