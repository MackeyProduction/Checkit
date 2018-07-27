package de.cbc.azubiproject.facades;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.IQuestionAnswer;
import de.cbc.azubiproject.interfaces.IUserGroup;
import de.cbc.azubiproject.interfaces.IUserSession;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.models.UserSession;

public class GroupFacade {
    public GroupFacade()
    {
    }

    public GroupContainer getContainer()
    {
        return new GroupContainer(new ArrayList<QuestionAnswer>(), new ArrayList<UserGroup>(), new ArrayList<UserSession>());
    }
}
