package de.cbc.azubiproject.models;

import java.security.acl.Group;
import java.util.Collection;

import de.cbc.azubiproject.interfaces.IGroup;
import de.cbc.azubiproject.interfaces.IUser;
import de.cbc.azubiproject.interfaces.IUserGroup;

public class UserGroup implements IUserGroup {
    private int userGroupId;
    private IUser user;
    private IGroup group;

    public UserGroup(int userGroupId, IUser user, IGroup group)
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
    public IUser getUser() {
        return user;
    }

    @Override
    public IGroup getGroup() {
        return group;
    }
}
