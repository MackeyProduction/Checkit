package de.cbc.azubiproject.containers;

import java.util.Collection;

import de.cbc.azubiproject.collections.QuestionAnswerCollection;
import de.cbc.azubiproject.collections.UserGroupCollection;
import de.cbc.azubiproject.collections.UserSessionCollection;

public class GroupContainer {
    private QuestionAnswerCollection qaCollection;
    private UserGroupCollection ugCollection;
    private UserSessionCollection usCollection;

    public GroupContainer(QuestionAnswerCollection qaCollection, UserGroupCollection ugCollection, UserSessionCollection usCollection)
    {
        this.qaCollection = qaCollection;
        this.ugCollection = ugCollection;
        this.usCollection = usCollection;
    }

    public QuestionAnswerCollection getQuestionAnswerCollection() {
        return qaCollection;
    }

    public UserGroupCollection getUserGroupCollection() {
        return ugCollection;
    }

    public UserSessionCollection getUserSessionCollection() {
        return usCollection;
    }
}
