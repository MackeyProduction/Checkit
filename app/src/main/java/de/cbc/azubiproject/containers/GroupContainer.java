package de.cbc.azubiproject.containers;

import de.cbc.azubiproject.interfaces.IQuestionAnswerRepository;
import de.cbc.azubiproject.interfaces.IUserGroupRepository;
import de.cbc.azubiproject.interfaces.IUserSessionRepository;
import de.cbc.azubiproject.repositories.QuestionAnswerRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;
import de.cbc.azubiproject.repositories.UserSessionRepository;

public class GroupContainer {
    private IQuestionAnswerRepository questionAnswer;
    private UserGroupRepository userGroup;
    private UserSessionRepository userSession;

    public GroupContainer(IQuestionAnswerRepository questionAnswer, UserGroupRepository userGroup, UserSessionRepository userSession)
    {
        this.questionAnswer = questionAnswer;
        this.userGroup = userGroup;
        this.userSession = userSession;
    }

    public IQuestionAnswerRepository getQuestionAnswerCollection() {
        return questionAnswer;
    }

    public UserGroupRepository getUserGroupCollection() {
        return userGroup;
    }

    public UserSessionRepository getUserSessionCollection() {
        return userSession;
    }
}
