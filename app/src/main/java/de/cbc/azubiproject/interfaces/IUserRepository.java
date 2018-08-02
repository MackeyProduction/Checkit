package de.cbc.azubiproject.interfaces;

import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;

public interface IUserRepository extends IRepository {
    public User getByUsername(String username);
}
