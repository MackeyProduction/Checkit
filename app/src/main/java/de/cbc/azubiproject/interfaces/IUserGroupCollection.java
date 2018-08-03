package de.cbc.azubiproject.interfaces;

import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.repositories.GroupRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public interface IUserGroupCollection {
    public UserRepository getUserRepository() throws ExecutionException, InterruptedException;
    public GroupRepository getGroupRepository() throws ExecutionException, InterruptedException;
}
