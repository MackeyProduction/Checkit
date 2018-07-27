package de.cbc.azubiproject.repositories;

import com.android.internal.util.Predicate;

import java.util.Collection;

import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.interfaces.IGroup;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.interfaces.IResponseRepository;
import de.cbc.azubiproject.interfaces.IUser;
import de.cbc.azubiproject.interfaces.IUserGroupRepository;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;

public class UserGroupRepository implements IUserGroupRepository {
    private Collection<UserGroup> userGroupCollection;

    public UserGroupRepository(Collection<UserGroup> userGroupCollection)
    {
        this.userGroupCollection = userGroupCollection;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public Collection<UserGroup> getByGroupId(int id) {
        return null;
    }

    @Override
    public boolean createNewGroup(IGroup group, Collection<User> user) {
        return new HttpRequest(new Endpoint("/group")).postRequest(null);
    }
}
