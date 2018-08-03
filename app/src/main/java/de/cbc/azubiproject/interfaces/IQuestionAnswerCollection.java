package de.cbc.azubiproject.interfaces;

import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.repositories.AnswerRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public interface IQuestionAnswerCollection {
    public UserRepository getUserGroupRepository() throws ExecutionException, InterruptedException;
    public QuestionRepository getQuestionRepository() throws ExecutionException, InterruptedException;
    public AnswerRepository getAnswerRepository() throws ExecutionException, InterruptedException;
}
