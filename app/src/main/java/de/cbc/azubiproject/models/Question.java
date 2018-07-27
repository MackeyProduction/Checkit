package de.cbc.azubiproject.models;

import de.cbc.azubiproject.interfaces.IQuestion;

public class Question implements IQuestion {
    private int questionId;
    private String questionName;

    public Question(int questionId, String questionName)
    {
        this.questionId = questionId;
        this.questionName = questionName;
    }

    @Override
    public int getQuestionId() {
        return questionId;
    }

    @Override
    public String getQuestionName() {
        return questionName;
    }
}
