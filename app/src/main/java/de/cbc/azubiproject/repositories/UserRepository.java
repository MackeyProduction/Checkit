package de.cbc.azubiproject.repositories;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.RetrieveUserSessionTask;
import de.cbc.azubiproject.asynctasks.RetrieveUserTask;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.UserResponse;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.interfaces.IUserRepository;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;

public class UserRepository implements IUserRepository {
    private static Collection<User> collection = null;

    protected UserRepository() {
    }

    public static Collection<User> getInstance() throws InterruptedException, ExecutionException
    {
        if (collection == null) {
            collection = (Collection<User>) new RetrieveUserTask().execute(new UserResponse(new HttpRequest(new Endpoint("/users.php")), collection)).get();
        }
        return collection;
    }

    @Override
    public Object getById(final int id) {
        return new FilterCollection(collection, user -> user.getUserId() == id).getCollection().toArray()[0];
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(collection, user -> user.getUserId() > 0).getCollection();
    }

    public User getByUsername(String username)
    {
        return (User) new FilterCollection(collection, user -> user.getUsername().equals(username)).getCollection().toArray()[0];
    }
}
