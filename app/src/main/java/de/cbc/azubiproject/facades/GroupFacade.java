package de.cbc.azubiproject.facades;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.collections.QuestionAnswerCollection;
import de.cbc.azubiproject.collections.UserGroupCollection;
import de.cbc.azubiproject.collections.UserSessionCollection;
import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.IQuestionAnswer;
import de.cbc.azubiproject.interfaces.IUserGroup;
import de.cbc.azubiproject.interfaces.IUserSession;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.models.UserSession;

public class GroupFacade {
    private int groupId;

    public GroupFacade(int groupId)
    {
        this.groupId = groupId;
    }

    public GroupContainer getContainer()
    {
        return new GroupContainer(new QuestionAnswerCollection(new ArrayList<QuestionAnswer>(), groupId), new UserGroupCollection(), new UserSessionCollection());
    }
}
