package de.cbc.azubiproject.interfaces;

import java.util.Collection;

import de.cbc.azubiproject.collections.UserGroupCollection;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;

public interface IUserGroupRepository extends IResponseRepository {
    public Collection<UserGroup> getByGroupId(int id);
    public Collection<UserGroup> getByUsername(String username);
    public HttpResponse createNewGroup(Collection<UserGroup> userGroupCollection);
    public UserGroupCollection getRepositories();
}
