package de.cbc.azubiproject.models;

import java.util.Date;

import de.cbc.azubiproject.interfaces.ISession;

public class Session implements ISession {
    @Override
    public int getSId() {
        return 0;
    }

    @Override
    public String getUser() {
        return null;
    }

    @Override
    public String getSessionId() {
        return null;
    }

    @Override
    public boolean isSessionActive() {
        return false;
    }

    @Override
    public Date getDelayDate() {
        return null;
    }
}
