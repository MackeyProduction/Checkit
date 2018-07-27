package de.cbc.azubiproject.models;

import java.security.acl.Group;
import java.util.Collection;

import de.cbc.azubiproject.interfaces.IUserGroup;

public class UserGroup implements IUserGroup {
    private Collection<User> userCollection;
    private Collection<Group> groupCollection;

    public UserGroup(Collection<User> userCollection, Collection<Group> groupCollection)
    {
        this.userCollection = userCollection;
        this.groupCollection = groupCollection;
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
