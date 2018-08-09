package de.cbc.azubiproject.repositories;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.HttpPostTask;
import de.cbc.azubiproject.asynctasks.RetrieveCountTask;
import de.cbc.azubiproject.asynctasks.RetrieveUserGroupTask;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.UserGroupResponse;
import de.cbc.azubiproject.interfaces.IUserGroupRepository;
import de.cbc.azubiproject.models.UserGroup;

public class UserGroupRepository implements IUserGroupRepository {
    private static Collection<UserGroup> userGroupCollection = null;
    private static UserGroupRepository userGroupRepository = null;
    private static Gson gson = null;

    protected UserGroupRepository(Collection<UserGroup> userGroups) {
        userGroupCollection = userGroups;
    }

    public static UserGroupRepository getInstance() throws ExecutionException, InterruptedException {
        if (userGroupRepository == null) {
            userGroupRepository = new UserGroupRepository(new RetrieveUserGroupTask().execute(new UserGroupResponse(new HttpRequest(new Endpoint("/userGroups.php")), userGroupCollection)).get());
            gson = new Gson();
        }
        return userGroupRepository;
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(userGroupCollection, userGroup -> userGroup.getUserGroupId() == id).getItem();
    }

    @Override
    public Collection getAll() {
        return new FilterCollection(userGroupCollection, userGroup -> userGroup.getUserGroupId() > 0).getCollection();
    }

    @Override
    public Collection<UserGroup> getByGroupId(int id) throws ExecutionException, InterruptedException {
        return (Collection<UserGroup>) new RetrieveUserGroupTask().execute(new UserGroupResponse(new HttpRequest(new Endpoint(String.format("/userGroups.php?groupId=%s", id))), userGroupCollection)).get();
    }

    public UserGroup getByGroupName(String groupName) throws ExecutionException, InterruptedException {
        Collection<UserGroup> collectionUg = new FilterCollection(userGroupCollection, userGroup -> userGroup.getGroup().getGroupName().equals(groupName)).getCollection();

        UserGroup ug = null;
        if (collectionUg != null) {
            ug = (UserGroup) collectionUg.toArray()[0];
        }
        return ug;
    }

    public Collection<UserGroup> getByUsername(String username)
    {
        return new FilterCollection(userGroupCollection, userGroupCollection -> userGroupCollection.getUser().getUsername().equals(username)).getCollection();
    }

    public String getGroupsActiveCount(String username) throws ExecutionException, InterruptedException {
        return new RetrieveCountTask().execute(new HttpRequest(new Endpoint(String.format("/userGroups.php?groups=%s", username)))).get();
    }

    @Override
    public boolean createNewGroup(Collection<UserGroup> userGroupCollection) throws ExecutionException, InterruptedException {
        return new HttpPostTask().execute(new HttpRequest(new Endpoint("/userGroups.php")).postRequest(gson.toJson(userGroupCollection))).get() != 5001;
    }
}
