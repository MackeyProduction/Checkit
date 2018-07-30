package de.cbc.azubiproject.facades;

import java.util.ArrayList;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.models.UserSession;
import de.cbc.azubiproject.repositories.QuestionAnswerRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;
import de.cbc.azubiproject.repositories.UserSessionRepository;

public class GroupFacade {
    public GroupFacade()
    {
    }

    public GroupContainer getContainer() {
        return new GroupContainer(
                new QuestionAnswerRepository(new ArrayList<QuestionAnswer>()),
                new UserGroupRepository(new ArrayList<UserGroup>()),
                new UserSessionRepository(new ArrayList<UserSession>())
        );
    }
}
