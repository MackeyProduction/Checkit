package de.cbc.azubiproject.interfaces;

import de.cbc.azubiproject.repositories.AnswerRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;

public interface IQuestionAnswer {
    public int questionAnswerId();
    public IUserGroup getUserGroup();
    public IQuestion getQuestion();
    public IAnswer getAnswer();
    public boolean isCorrect();
}
