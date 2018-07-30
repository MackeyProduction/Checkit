package de.cbc.azubiproject.containers;

import de.cbc.azubiproject.interfaces.IQuestionAnswerRepository;
import de.cbc.azubiproject.interfaces.IUserGroupRepository;
import de.cbc.azubiproject.interfaces.IUserSessionRepository;

public class GroupContainer {
    private IQuestionAnswerRepository questionAnswer;
    private IUserGroupRepository userGroup;
    private IUserSessionRepository userSession;

    public GroupContainer(IQuestionAnswerRepository questionAnswer, IUserGroupRepository userGroup, IUserSessionRepository userSession)
    {
        this.questionAnswer = questionAnswer;
        this.userGroup = userGroup;
        this.userSession = userSession;
    }

    public IQuestionAnswerRepository getQuestionAnswerCollection() {
        return questionAnswer;
    }

    public IUserGroupRepository getUserGroupCollection() {
        return userGroup;
    }

    public IUserSessionRepository getUserSessionCollection() {
        return userSession;
    }
}
