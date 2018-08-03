package de.cbc.azubiproject.repositories;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.RetrieveAnswerTypeTask;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.AnswerTypeResponse;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.AnswerType;

public class AnswerTypeRepository implements IRepository {
    private static Collection<AnswerType> answerTypeCollection = null;

    public AnswerTypeRepository() {
    }

    public static Collection<AnswerType> getInstance() throws ExecutionException, InterruptedException {
        if (answerTypeCollection == null) {
            answerTypeCollection = (Collection<AnswerType>) new RetrieveAnswerTypeTask().execute(new AnswerTypeResponse(new HttpRequest(new Endpoint("/answerTypes.php")), answerTypeCollection)).get();
        }
        return answerTypeCollection;
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(answerTypeCollection, answerType -> answerType.getAnswerTypeId() == id);
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(answerTypeCollection, answerType -> answerType.getAnswerTypeId() > 0).getCollection();
    }
}
