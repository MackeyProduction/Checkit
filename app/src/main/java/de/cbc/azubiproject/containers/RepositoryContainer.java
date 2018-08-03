package de.cbc.azubiproject.containers;

import de.cbc.azubiproject.interfaces.IQuestionAnswerCollection;
import de.cbc.azubiproject.interfaces.IUserGroupCollection;
import de.cbc.azubiproject.interfaces.IUserSessionCollection;

public class RepositoryContainer {
    private IQuestionAnswerCollection questionAnswerCollection;
    private IUserGroupCollection userGroupCollection;
    private IUserSessionCollection userSessionCollection;

    public RepositoryContainer(IQuestionAnswerCollection questionAnswerCollection, IUserGroupCollection userGroupCollection, IUserSessionCollection userSessionCollection)
    {
        this.questionAnswerCollection = questionAnswerCollection;
        this.userGroupCollection = userGroupCollection;
        this.userSessionCollection = userSessionCollection;
    }


    public IQuestionAnswerCollection getQuestionAnswerCollection() {
        return questionAnswerCollection;
    }

    public IUserGroupCollection getUserGroupCollection() {
        return userGroupCollection;
    }

    public IUserSessionCollection getUserSessionCollection() {
        return userSessionCollection;
    }
}
