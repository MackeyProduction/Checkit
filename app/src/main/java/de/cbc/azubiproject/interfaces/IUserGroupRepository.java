package de.cbc.azubiproject.interfaces;

import java.util.Collection;

import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;

public interface IUserGroupRepository extends IResponseRepository {
    public Collection<UserGroup> getByGroupId(int id);
    public boolean createNewGroup(Collection<UserGroup> userGroupCollection);
}
