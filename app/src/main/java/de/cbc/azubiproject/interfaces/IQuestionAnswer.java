package de.cbc.azubiproject.interfaces;

import de.cbc.azubiproject.models.Answer;
import de.cbc.azubiproject.models.Question;
import de.cbc.azubiproject.models.UserGroup;

public interface IQuestionAnswer {
    public int questionAnswerId();
    public UserGroup getUserGroup();
    public Question getQuestion();
    public Answer getAnswer();
    public int isCorrect();
}
