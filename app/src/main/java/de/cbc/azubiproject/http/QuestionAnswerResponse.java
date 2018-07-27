package de.cbc.azubiproject.http;

import org.json.JSONObject;
import java.util.Collection;
import de.cbc.azubiproject.interfaces.AbstractHttpResponse;

public class QuestionAnswerResponse extends AbstractHttpResponse {
    public QuestionAnswerResponse(HttpResponse response) {
        super(response);
    }

    @Override
    protected Collection<JSONObject> parse(Collection<JSONObject> collection) {
        return null;
    }
}
