package de.cbc.azubiproject.repositories;

import com.android.internal.util.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.RetrieveAnswerTask;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.AnswerResponse;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.Answer;

public class AnswerRepository implements IRepository {
    private static Collection<Answer> answerCollection = null;
    private static AnswerRepository answerRepository = null;

    protected AnswerRepository(Collection<Answer> answers) {
        answerCollection = answers;
    }

    public static AnswerRepository getInstance() throws ExecutionException, InterruptedException {
        if (answerRepository == null) {
            answerRepository = new AnswerRepository(new RetrieveAnswerTask().execute(new AnswerResponse(new HttpRequest(new Endpoint("/answers.php")), new ArrayList<Answer>())).get());
        }
        return answerRepository;
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(answerCollection, answer -> answer.getAnswerId() == id);
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(answerCollection, answer -> answer.getAnswerId() > 0).getCollection();
    }
}
