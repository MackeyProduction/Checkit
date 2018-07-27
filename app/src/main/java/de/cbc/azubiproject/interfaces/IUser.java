package de.cbc.azubiproject.interfaces;

public interface IUser {
    public int getUserId();
    public String getUsername();
    public String getPassword();
    public IProfile getProfile();
}
