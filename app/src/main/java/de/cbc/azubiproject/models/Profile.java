package de.cbc.azubiproject.models;

import de.cbc.azubiproject.interfaces.IProfile;

public class Profile implements IProfile {
    private int profileId;
    private String firstName, lastName, email, birthdate;

    public Profile(int profileId, String firstName, String lastName, String email, String birthdate)
    {
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
    }

    @Override
    public int getProfileId() {
        return profileId;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getBirthDate() {
        return birthdate;
    }
}
