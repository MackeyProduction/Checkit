package de.cbc.azubiproject.http;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.AbstractHttpResponse;
import de.cbc.azubiproject.models.QuestionAnswer;

public class QuestionAnswerResponse extends AbstractHttpResponse {
    public QuestionAnswerResponse(HttpResponse response, Collection<QuestionAnswer> collection) {
        super(response, collection);
    }

    @Override
    protected Collection<QuestionAnswer> parse(Collection<JSONObject> collection, Collection container) {
        return new ArrayList<QuestionAnswer>();
    }
}
