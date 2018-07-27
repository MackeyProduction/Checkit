package de.cbc.azubiproject.models;

import java.security.acl.Group;
import java.util.Collection;

import de.cbc.azubiproject.interfaces.IUserGroup;

public class UserGroup implements IUserGroup {
    @Override
    public Collection<User> getUsers() {
        return null;
    }

    @Override
    public Collection<Group> getGroups() {
        return null;
    }
}
