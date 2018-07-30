package de.cbc.azubiproject.interfaces;

import de.cbc.azubiproject.repositories.AnswerRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public interface IQuestionAnswerCollection {
    public UserRepository getUserGroupRepository();
    public QuestionRepository getQuestionRepository();
    public AnswerRepository getAnswerRepository();
}
