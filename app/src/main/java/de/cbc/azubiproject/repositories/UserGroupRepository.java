package de.cbc.azubiproject.repositories;

import com.android.internal.util.Predicate;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.RetrieveUserGroupTask;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.collections.UserGroupCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.http.UserGroupResponse;
import de.cbc.azubiproject.interfaces.IGroup;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.interfaces.IResponseRepository;
import de.cbc.azubiproject.interfaces.IUser;
import de.cbc.azubiproject.interfaces.IUserGroupRepository;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;

public class UserGroupRepository implements IUserGroupRepository {
    private Collection<UserGroup> userGroupCollection;
    private Gson gson;

    public UserGroupRepository(Collection<UserGroup> userGroupCollection)
    {
        this.userGroupCollection = (Collection<UserGroup>) getAll();
        this.gson = new Gson();
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(userGroupCollection, userGroup -> userGroup.getUserGroupId() == id).getItem();
    }

    @Override
    public Collection getAll() {
        try {
            userGroupCollection = (Collection<UserGroup>) new RetrieveUserGroupTask().execute(new UserGroupResponse(new HttpRequest(new Endpoint("/userGroups.php")), userGroupCollection)).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return userGroupCollection;
    }

    @Override
    public Collection<UserGroup> getByGroupId(int id) {
        return new UserGroupResponse(new HttpRequest(new Endpoint(String.format("/userGroups.php?groupId=%s", id))), userGroupCollection).getCollection();
    }

    public Collection<UserGroup> getByUsername(String username)
    {
        return new FilterCollection(userGroupCollection, userGroupCollection -> userGroupCollection.getUser().getUsername().equals(username)).getCollection();
    }

    public UserGroupCollection getRepositories()
    {
        return new UserGroupCollection(getAll());
    }

    @Override
    public HttpResponse createNewGroup(Collection<UserGroup> userGroupCollection) {
        return new HttpRequest(new Endpoint("/userGroups.php")).postRequest(gson.toJson(userGroupCollection));
    }
}
