package de.cbc.azubiproject.models;

import com.google.gson.InstanceCreator;

import java.io.Serializable;
import java.lang.reflect.Type;

import de.cbc.azubiproject.interfaces.IProfile;
import de.cbc.azubiproject.interfaces.IUser;

public class User implements IUser {
    private int userId;
    private String username, password, salt, registerDate;
    private IProfile profile;

    public User()
    {
        super();
    }

    public User(int userId, String username, String password, String salt, String registerDate, IProfile profile)
    {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.registerDate = registerDate;
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
    public String getSalt() {
        return salt;
    }

    @Override
    public String getRegisterDate() {
        return registerDate;
    }

    @Override
    public IProfile getProfile() {
        return profile;
    }
}
