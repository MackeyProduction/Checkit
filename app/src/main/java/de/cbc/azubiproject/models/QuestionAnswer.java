package de.cbc.azubiproject.models;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IQuestionAnswer;

public class QuestionAnswer implements IQuestionAnswer {
    private Collection<UserGroup> userGroupCollection;
    private Collection<Question> questionCollection;
    private Collection<Answer> answerCollection;
    private boolean isCorrect;

    public QuestionAnswer(Collection<UserGroup> userGroupCollection, Collection<Question> questionCollection, Collection<Answer> answerCollection, boolean isCorrect)
    {
        this.userGroupCollection = userGroupCollection;
        this.questionCollection = questionCollection;
        this.answerCollection = answerCollection;
        this.isCorrect = isCorrect;
    }

    @Override
    public Collection getUserGroups() {
        return userGroupCollection;
    }

    @Override
    public Collection<Question> getQuestions() {
        return questionCollection;
    }

    @Override
    public Collection<Answer> getAnswers() {
        return answerCollection;
    }

    @Override
    public boolean isCorrect() {
        return isCorrect;
    }
}
