package de.cbc.azubiproject.interfaces;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.collections.UserGroupCollection;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;

public interface IUserGroupRepository extends IResponseRepository {
    public Collection<UserGroup> getByGroupId(int id) throws ExecutionException, InterruptedException;
    public Collection<UserGroup> getByUsername(String username);
    public boolean createNewGroup(Collection<UserGroup> userGroupCollection) throws ExecutionException, InterruptedException;
}
