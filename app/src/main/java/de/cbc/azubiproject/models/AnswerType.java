package de.cbc.azubiproject.models;

import de.cbc.azubiproject.interfaces.IAnswerType;

public class AnswerType implements IAnswerType {
    private int answerTypeId;
    private String answerType;

    public AnswerType()
    {
        super();
    }

    public AnswerType(int answerTypeId, String answerType)
    {
        this.answerTypeId = answerTypeId;
        this.answerType = answerType;
    }

    @Override
    public int getAnswerTypeId() {
        return answerTypeId;
    }

    @Override
    public String getAnswerType() {
        return answerType;
    }
}
