package de.cbc.azubiproject.models;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IGroup;
import de.cbc.azubiproject.interfaces.IRepository;

public class Group implements IGroup {
    private int groupId;
    private String groupName;

    public Group()
    {
        super();
    }

    public Group(int groupId, String groupName)
    {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public int getGroupId() {
        return groupId;
    }

    @Override
    public String getGroupName() {
        return groupName;
    }
}
