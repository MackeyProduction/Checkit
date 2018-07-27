package de.cbc.azubiproject.models;

import de.cbc.azubiproject.interfaces.IAnswer;

public class Answer implements IAnswer {
    private int answerId;
    private String answer;
    private AnswerType answerType;

    public Answer(int answerId, String answer, AnswerType answerType)
    {
        this.answerId = answerId;
        this.answer = answer;
        this.answerType = answerType;
    }

    @Override
    public int getAnswerId() {
        return answerId;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public AnswerType getAnswerType() {
        return answerType;
    }
}
