package de.cbc.azubiproject.repositories;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.http.QuestionAnswerResponse;
import de.cbc.azubiproject.interfaces.IQuestionAnswerRepository;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.QuestionAnswer;

public class QuestionAnswerRepository implements IRepository {
    @Override
    public Collection getById(int id) {
        return new QuestionAnswerResponse(new HttpResponse(new HttpRequest(new Endpoint(String.format("/group/%s/", id))), new ArrayList<JSONObject>()), new ArrayList<QuestionAnswer>()).getCollection();
    }

    @Override
    public Collection getAll() {
        return getById(1);
    }
}
