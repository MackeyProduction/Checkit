package de.cbc.azubiproject.repositories;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.UserGroup;

public class UserGroupRepository implements IRepository {
    private Collection<UserGroup> userGroupCollection;
    private int groupId;

    public UserGroupRepository(Collection<UserGroup> userGroupCollection, int groupId)
    {
        this.userGroupCollection = userGroupCollection;
        this.groupId = groupId;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public <T> Collection<T> getAll() {
        return null;
    }
}
