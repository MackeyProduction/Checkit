package de.cbc.azubiproject.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.cbc.azubiproject.interfaces.AbstractHttpResponse;
import de.cbc.azubiproject.interfaces.IHttpRequest;
import de.cbc.azubiproject.models.Answer;

public class AnswerResponse extends AbstractHttpResponse {
    public AnswerResponse(IHttpRequest request, Collection collection) {
        super(request, collection);
    }

    @Override
    protected Collection parse(HttpResponse httpResponse, Collection container) {
        Gson gson = new Gson();

        List<Answer> responseList = (ArrayList<Answer>)httpResponse.getResponse();
        String response = gson.toJson(responseList);
        Collection<Answer> answers = gson.fromJson(response, new TypeToken<List<Answer>>(){}.getType());

        return answers;
    }
}
