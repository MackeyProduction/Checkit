package de.cbc.azubiproject.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.AbstractHttpResponse;
import de.cbc.azubiproject.interfaces.IHttpRequest;
import de.cbc.azubiproject.models.Answer;
import de.cbc.azubiproject.models.Question;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.AnswerRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;

public class QuestionAnswerResponse extends AbstractHttpResponse {
    public QuestionAnswerResponse(IHttpRequest request, Collection collection) {
        super(request, collection);
    }

    @Override
    protected Collection parse(HttpResponse httpResponse, Collection container) {
        Gson gson = new Gson();

        List<QuestionAnswer> responseList = (ArrayList<QuestionAnswer>)httpResponse.getResponse();
        String response = gson.toJson(responseList);
        Collection<QuestionAnswer> questions = gson.fromJson(response, new TypeToken<List<QuestionAnswer>>(){}.getType());

        return questions;
    }
}
