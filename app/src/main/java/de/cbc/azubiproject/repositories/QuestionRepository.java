package de.cbc.azubiproject.repositories;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.RetrieveQuestionRepository;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.QuestionResponse;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.Question;

public class QuestionRepository implements IRepository {
    private static Collection<Question> questionCollection = null;
    private static QuestionRepository questionRepository = null;

    private QuestionRepository(Collection<Question> questions) {
        questionCollection = questions;
    }

    public static QuestionRepository getInstance() throws ExecutionException, InterruptedException {
        if (questionRepository == null) {
            questionRepository = new QuestionRepository(new RetrieveQuestionRepository().execute(new QuestionResponse(new HttpRequest(new Endpoint("/questions.php")), questionCollection)).get());
        }
        return questionRepository;
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(questionCollection, question -> question.getQuestionId() == id);
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(questionCollection, question -> question.getQuestionId() > 0).getCollection();
    }
}
