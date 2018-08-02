package de.cbc.azubiproject.collections;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.interfaces.IUserGroupCollection;
import de.cbc.azubiproject.models.Group;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.GroupRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public class UserGroupCollection implements IUserGroupCollection {
    private Collection<UserGroup> userGroupCollection;

    public UserGroupCollection(Collection<UserGroup> userGroupCollection)
    {
        this.userGroupCollection = userGroupCollection;
    }

    public UserRepository getUserRepository()
    {
        return new UserRepository(new FilterCollection(userGroupCollection, userGroup -> userGroup.getUser().getUserId() > 0).getCollection());
    }

    public GroupRepository getGroupRepository()
    {
        return new GroupRepository(new FilterCollection(userGroupCollection, userGroup -> userGroup.getGroup().getGroupId() > 0).getCollection());
    }
}
