package de.cbc.azubiproject.models;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IGroup;
import de.cbc.azubiproject.interfaces.IUser;
import de.cbc.azubiproject.interfaces.IUserGroup;

public class UserGroup implements IUserGroup {
    private int userGroupId;
    private User user;
    private Group group;
    private int created;

    public UserGroup()
    {
        super();
    }

    public UserGroup(int userGroupId, User user, Group group, int created)
    {
        this.userGroupId = userGroupId;
        this.user = user;
        this.group = group;
        this.created = created;
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

    public int getCreated() {
        return created;
    }
}
