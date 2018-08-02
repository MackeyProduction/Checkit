package de.cbc.azubiproject.interfaces;

import de.cbc.azubiproject.models.Profile;

public interface IUser {
    public int getUserId();
    public String getUsername();
    public String getPassword();
    public String getSalt();
    public String getRegisterDate();
    public Profile getProfile();
}
