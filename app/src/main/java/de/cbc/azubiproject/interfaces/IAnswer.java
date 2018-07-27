package de.cbc.azubiproject.interfaces;

import de.cbc.azubiproject.models.AnswerType;

public interface IAnswer {
    public int getAnswerId();
    public String getAnswer();
    public AnswerType getAnswerType();
}
