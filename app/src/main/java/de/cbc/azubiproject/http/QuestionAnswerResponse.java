package de.cbc.azubiproject.http;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.AbstractHttpResponse;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.AnswerRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;

public class QuestionAnswerResponse extends AbstractHttpResponse {
    public QuestionAnswerResponse(HttpResponse response, Collection<QuestionAnswer> collection) {
        super(response, collection);
    }

    @Override
    protected Collection<QuestionAnswer> parse(Collection<JSONObject> collection, Collection container) {
        Collection<QuestionAnswer> questionAnswerCollection = new ArrayList<>();

        QuestionAnswer questionAnswer = new QuestionAnswer(
                1,
                new UserGroupRepository(new ArrayList<UserGroup>()),
                new QuestionRepository(null),
                new AnswerRepository(null),
                true
        );

        questionAnswerCollection.add(questionAnswer);

        return questionAnswerCollection;
    }
}
