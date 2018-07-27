package de.cbc.azubiproject.models;

import de.cbc.azubiproject.interfaces.IProfile;
import de.cbc.azubiproject.interfaces.IUser;

public class User implements IUser {
    private int userId;
    private String username, password;
    private IProfile profile;

    public User(int userId, String username, String password, IProfile profile)
    {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public IProfile getProfile() {
        return profile;
    }
}
