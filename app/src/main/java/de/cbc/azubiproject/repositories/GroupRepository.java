package de.cbc.azubiproject.repositories;

import com.android.internal.util.Predicate;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.RetrieveGroupTask;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.GroupResponse;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.Group;

public class GroupRepository implements IRepository {
    private static Collection<Group> groupCollection = null;
    private static GroupRepository groupRepository = null;

    private GroupRepository(Collection<Group> groups) {
        groupCollection = groups;
    }

    public static GroupRepository getInstance() throws ExecutionException, InterruptedException {
        if (groupRepository == null) {
            groupRepository = new GroupRepository(new RetrieveGroupTask().execute(new GroupResponse(new HttpRequest(new Endpoint("/groups.php")), groupCollection)).get());
        }
        return groupRepository;
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(groupCollection, group -> group.getGroupId() == id).getCollection().toArray()[0];
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(groupCollection, group -> group.getGroupId() > 0).getCollection();
    }
}
