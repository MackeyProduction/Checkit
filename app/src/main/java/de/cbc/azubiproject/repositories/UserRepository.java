package de.cbc.azubiproject.repositories;

import com.android.internal.util.Predicate;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.collections.UserCollection;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.User;

public class UserRepository implements IRepository {
    private Collection<User> collection;

    public UserRepository(Collection<User> collection)
    {
        this.collection = collection;
    }

    @Override
    public Object getById(final int id) {
        return new FilterCollection(collection, user -> user.getUserId() == id).getCollection().toArray()[0];
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(collection, user -> user.getUserId() > 0).getCollection();
    }
}
