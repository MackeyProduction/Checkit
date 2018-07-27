package de.cbc.azubiproject.models;

import de.cbc.azubiproject.interfaces.IAnswer;

public class Answer implements IAnswer {
    @Override
    public int getAnswerId() {
        return 0;
    }

    @Override
    public String getAnswer() {
        return null;
    }

    @Override
    public AnswerType getAnswerType() {
        return null;
    }
}
