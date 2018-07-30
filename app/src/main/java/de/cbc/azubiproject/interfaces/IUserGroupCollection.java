package de.cbc.azubiproject.interfaces;

import de.cbc.azubiproject.repositories.GroupRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public interface IUserGroupCollection {
    public UserRepository getUserRepository();
    public GroupRepository getGroupRepository();
}
