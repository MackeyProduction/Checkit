package de.cbc.azubiproject.repositories;

import com.android.internal.util.Predicate;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.collections.QuestionAnswerCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.http.QuestionAnswerResponse;
import de.cbc.azubiproject.interfaces.IQuestionAnswer;
import de.cbc.azubiproject.interfaces.IQuestionAnswerRepository;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.interfaces.IResponseRepository;
import de.cbc.azubiproject.models.QuestionAnswer;

public class QuestionAnswerRepository implements IQuestionAnswerRepository {
    private Collection<QuestionAnswer> questionAnswerCollection;

    public QuestionAnswerRepository(Collection<QuestionAnswer> questionAnswerCollection)
    {
        //this.questionAnswerCollection = (Collection<QuestionAnswer>) new QuestionAnswerResponse(new HttpRequest(new Endpoint("/questionAnswer.php")), questionAnswerCollection).getCollection();
    }

    @Override
    public Object getById(final int id)
    {
        return new FilterCollection(questionAnswerCollection, questionAnswer -> questionAnswer.questionAnswerId() == id);
    }

    public Collection<QuestionAnswer> getByGroupId(int id)
    {
        return new QuestionAnswerResponse(new HttpRequest(new Endpoint(String.format("/questionAnswer.php?groupId=%s", id))), questionAnswerCollection).getCollection();
    }

    public QuestionAnswerCollection getRepositories()
    {
        return new QuestionAnswerCollection((Collection<QuestionAnswer>) getAll());
    }

    @Override
    public Collection getAll() {
        return questionAnswerCollection;
    }
}
