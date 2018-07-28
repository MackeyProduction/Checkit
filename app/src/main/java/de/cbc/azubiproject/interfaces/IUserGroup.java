package de.cbc.azubiproject.interfaces;

import java.security.acl.Group;
import java.util.Collection;

import de.cbc.azubiproject.models.User;

public interface IUserGroup {
    public int getUserGroupId();
    public Collection<User> getUsers();
    public Collection<Group> getGroups();
}
