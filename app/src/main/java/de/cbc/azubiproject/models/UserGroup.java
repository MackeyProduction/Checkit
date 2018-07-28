package de.cbc.azubiproject.models;

import java.security.acl.Group;
import java.util.Collection;

import de.cbc.azubiproject.interfaces.IUserGroup;

public class UserGroup implements IUserGroup {
    private int userGroupId;
    private Collection<User> userCollection;
    private Collection<Group> groupCollection;

    public UserGroup(int userGroupId, Collection<User> userCollection, Collection<Group> groupCollection)
    {
        this.userGroupId = userGroupId;
        this.userCollection = userCollection;
        this.groupCollection = groupCollection;
    }

    @Override
    public int getUserGroupId() {
        return userGroupId;
    }

    @Override
    public Collection<User> getUsers() {
        return userCollection;
    }

    @Override
    public Collection<Group> getGroups() {
        return groupCollection;
    }
}
