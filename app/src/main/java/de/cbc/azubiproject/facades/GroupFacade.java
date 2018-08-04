package de.cbc.azubiproject.facades;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.collections.QuestionAnswerCollection;
import de.cbc.azubiproject.collections.UserGroupCollection;
import de.cbc.azubiproject.collections.UserSessionCollection;
import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.containers.RepositoryContainer;
import de.cbc.azubiproject.interfaces.IQuestionAnswerRepository;
import de.cbc.azubiproject.interfaces.IUserGroupRepository;
import de.cbc.azubiproject.interfaces.IUserSessionRepository;
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

    public GroupContainer getContainer() throws ExecutionException, InterruptedException {
        return new GroupContainer(
                QuestionAnswerRepository.getInstance(),
                UserGroupRepository.getInstance(),
                UserSessionRepository.getInstance()
        );
    }

    public RepositoryContainer getRepositories() {
        return new RepositoryContainer(
                new QuestionAnswerCollection(),
                new UserGroupCollection(),
                new UserSessionCollection()
        );
    }
}
