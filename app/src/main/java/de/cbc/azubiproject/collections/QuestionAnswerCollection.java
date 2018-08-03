package de.cbc.azubiproject.collections;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.interfaces.IQuestionAnswerCollection;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.repositories.AnswerRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public class QuestionAnswerCollection implements IQuestionAnswerCollection {
    public QuestionAnswerCollection() {
    }

    public UserRepository getUserGroupRepository() throws ExecutionException, InterruptedException {
        return (UserRepository) UserRepository.getInstance();
    }

    public QuestionRepository getQuestionRepository() throws ExecutionException, InterruptedException {
        return (QuestionRepository) QuestionRepository.getInstance();
    }

    public AnswerRepository getAnswerRepository() throws ExecutionException, InterruptedException
    {
        return (AnswerRepository) AnswerRepository.getInstance();
    }
}
