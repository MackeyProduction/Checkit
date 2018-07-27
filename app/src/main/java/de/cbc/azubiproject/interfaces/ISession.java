package de.cbc.azubiproject.interfaces;

import java.util.Date;

public interface ISession {
    public int getSId();
    public String getUser();
    public String getSessionId();
    public boolean isSessionActive();
    public Date getDelayDate();
}
