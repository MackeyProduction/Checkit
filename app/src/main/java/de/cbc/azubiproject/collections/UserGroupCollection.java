package de.cbc.azubiproject.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.interfaces.IUserGroupCollection;
import de.cbc.azubiproject.models.Group;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.GroupRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public class UserGroupCollection implements IUserGroupCollection {
    public UserGroupCollection() {
    }

    public UserRepository getUserRepository() throws ExecutionException, InterruptedException {
        return (UserRepository) UserRepository.getInstance();
    }

    public GroupRepository getGroupRepository() throws ExecutionException, InterruptedException {
        return (GroupRepository) GroupRepository.getInstance();
    }
}
