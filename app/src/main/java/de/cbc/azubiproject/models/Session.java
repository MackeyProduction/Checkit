package de.cbc.azubiproject.models;

import java.util.Date;

import de.cbc.azubiproject.interfaces.ISession;

public class Session implements ISession {
    private int sId;
    private User user;
    private String sessionId;
    private boolean isSessionActive;
    private Date delayDate;

    public Session()
    {
        super();
    }

    public Session(int sId, User user, String sessionId, boolean isSessionActive, Date delayDate)
    {
        this.sId = sId;
        this.user = user;
        this.sessionId = sessionId;
        this.isSessionActive = isSessionActive;
        this.delayDate = delayDate;
    }

    @Override
    public int getSId() {
        return sId;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public String getSessionId() {
        return sessionId;
    }

    @Override
    public boolean isSessionActive() {
        return isSessionActive;
    }

    @Override
    public Date getDelayDate() {
        return delayDate;
    }
}
