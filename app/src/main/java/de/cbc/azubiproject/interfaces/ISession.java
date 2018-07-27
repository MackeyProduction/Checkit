package de.cbc.azubiproject.interfaces;

import java.util.Date;
import de.cbc.azubiproject.models.User;

public interface ISession {
    public int getSId();
    public User getUser();
    public String getSessionId();
    public boolean isSessionActive();
    public Date getDelayDate();
}
