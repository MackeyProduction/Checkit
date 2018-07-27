package de.cbc.azubiproject.models;

import de.cbc.azubiproject.interfaces.IQuestion;

public class Question implements IQuestion {
    @Override
    public int getQuestionId() {
        return 0;
    }

    @Override
    public String getQuestionName() {
        return null;
    }
}
