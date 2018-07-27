package de.cbc.azubiproject.models;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IQuestionAnswer;

public class QuestionAnswer implements IQuestionAnswer {
    @Override
    public Collection<UserGroup> getUserGroups() {
        return null;
    }

    @Override
    public Collection<Question> getQuestions() {
        return null;
    }

    @Override
    public Collection<Answer> getAnswers() {
        return null;
    }

    @Override
    public boolean isCorrect() {
        return false;
    }
}
