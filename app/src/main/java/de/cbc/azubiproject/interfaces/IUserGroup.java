package de.cbc.azubiproject.interfaces;

import java.util.Collection;

import de.cbc.azubiproject.models.Group;
import de.cbc.azubiproject.models.User;

public interface IUserGroup {
    public int getUserGroupId();
    public User getUser();
    public Group getGroup();
}
