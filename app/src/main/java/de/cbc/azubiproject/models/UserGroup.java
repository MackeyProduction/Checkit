package de.cbc.azubiproject.models;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IGroup;
import de.cbc.azubiproject.interfaces.IUser;
import de.cbc.azubiproject.interfaces.IUserGroup;

public class UserGroup implements IUserGroup {
    private int userGroupId;
    private User user;
    private Group group;

    public UserGroup()
    {
        super();
    }

    public UserGroup(int userGroupId, User user, Group group)
    {
        this.userGroupId = userGroupId;
        this.user = user;
        this.group = group;
    }

    @Override
    public int getUserGroupId() {
        return userGroupId;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Group getGroup() {
        return group;
    }
}
