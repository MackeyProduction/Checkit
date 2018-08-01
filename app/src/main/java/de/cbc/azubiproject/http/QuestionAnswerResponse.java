package de.cbc.azubiproject.http;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.interfaces.AbstractHttpResponse;
import de.cbc.azubiproject.models.Answer;
import de.cbc.azubiproject.models.Question;
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
    protected Collection<QuestionAnswer> parse(String json, Collection container) {
        Gson gson = new Gson();
        gson.fromJson(json, QuestionAnswer.class);

        Collection<QuestionAnswer> questionAnswerCollection = new ArrayList<>();

        QuestionAnswer questionAnswer = new QuestionAnswer(
                1,
                new UserGroup(1, null, null),
                new Question(1, null),
                new Answer(1, null, null),
                true
        );

        questionAnswerCollection.add(questionAnswer);

        return questionAnswerCollection;
    }
}
