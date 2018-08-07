package de.cbc.azubiproject.models;

import de.cbc.azubiproject.interfaces.IQuestion;

public class Question implements IQuestion {
    private int questionId;
    private String question;

    public Question()
    {
        super();
    }

    public Question(int questionId, String question)
    {
        this.questionId = questionId;
        this.question = question;
    }

    @Override
    public int getQuestionId() {
        return questionId;
    }

    @Override
    public String getQuestion() {
        return question;
    }
}
