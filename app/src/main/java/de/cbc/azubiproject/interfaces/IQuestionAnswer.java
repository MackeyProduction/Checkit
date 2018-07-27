package de.cbc.azubiproject.interfaces;

import java.util.Collection;

import de.cbc.azubiproject.models.Answer;
import de.cbc.azubiproject.models.Question;
import de.cbc.azubiproject.models.UserGroup;

public interface IQuestionAnswer {
    public Collection<UserGroup> getUserGroups();
    public Collection<Question> getQuestions();
    public Collection<Answer> getAnswers();
    public boolean isCorrect();
}
