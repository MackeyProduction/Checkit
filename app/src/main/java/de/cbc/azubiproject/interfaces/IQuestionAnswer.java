package de.cbc.azubiproject.interfaces;

import de.cbc.azubiproject.repositories.AnswerRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;

public interface IQuestionAnswer {
    public int questionAnswerId();
    public IResponseRepository getUserGroups();
    public IRepository getQuestions();
    public IRepository getAnswers();
    public boolean isCorrect();
}
