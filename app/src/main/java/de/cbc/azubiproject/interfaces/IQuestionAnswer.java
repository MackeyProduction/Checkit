package de.cbc.azubiproject.interfaces;

import de.cbc.azubiproject.repositories.AnswerRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;

public interface IQuestionAnswer {
    public UserGroupRepository getUserGroups();
    public QuestionRepository getQuestions();
    public AnswerRepository getAnswers();
    public boolean isCorrect();
}
