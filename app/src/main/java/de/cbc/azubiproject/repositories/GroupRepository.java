package de.cbc.azubiproject.repositories;

import com.android.internal.util.Predicate;

import java.util.Collection;

import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.GroupResponse;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.Group;

public class GroupRepository implements IRepository {
    private Collection<Group> groupCollection;

    public GroupRepository(Collection<Group> groupCollection)
    {
        this.groupCollection = new GroupResponse(new HttpRequest(new Endpoint("/groups.php")), groupCollection).getCollection();
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(groupCollection, group -> group.getGroupId() == id);
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(groupCollection, group -> group.getGroupId() > 0).getCollection();
    }
}
