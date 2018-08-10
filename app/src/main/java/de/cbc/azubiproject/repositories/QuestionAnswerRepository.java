package de.cbc.azubiproject.repositories;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.RetrieveCountTask;
import de.cbc.azubiproject.asynctasks.RetrieveQuestionAnswerTask;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.QuestionAnswerResponse;
import de.cbc.azubiproject.interfaces.IQuestionAnswerRepository;
import de.cbc.azubiproject.models.QuestionAnswer;

public class QuestionAnswerRepository implements IQuestionAnswerRepository {
    private static Collection<QuestionAnswer> questionAnswerCollection = null;
    private static QuestionAnswerRepository questionAnswerRepository = null;

    public static QuestionAnswerRepository getInstance(boolean refresh) throws InterruptedException, ExecutionException
    {
        if (questionAnswerRepository == null || refresh) {
            questionAnswerRepository = new QuestionAnswerRepository(new RetrieveQuestionAnswerTask().execute(new QuestionAnswerResponse(new HttpRequest(new Endpoint("/questionAnswer.php")), questionAnswerCollection)).get());
        }
        return questionAnswerRepository;
    }

    protected QuestionAnswerRepository(Collection<QuestionAnswer> questionAnswers) {
        questionAnswerCollection = questionAnswers;
    }

    @Override
    public Object getById(final int id) {
        return new FilterCollection(questionAnswerCollection, questionAnswer -> questionAnswer.questionAnswerId() == id);
    }

    public Collection<QuestionAnswer> getByGroupId(int id) throws InterruptedException, ExecutionException {
        return new RetrieveQuestionAnswerTask().execute(new QuestionAnswerResponse(new HttpRequest(new Endpoint(String.format("/questionAnswer.php?groupId=%s", id))), questionAnswerCollection)).get();
    }

    public Collection<QuestionAnswer> getByAnswerType(int groupId, String answerType) throws InterruptedException, ExecutionException
    {
        return new RetrieveQuestionAnswerTask().execute(new QuestionAnswerResponse(new HttpRequest(new Endpoint(String.format("/questionAnswer.php?answerType=%s&groupId=%s", answerType, groupId))), questionAnswerCollection)).get();
    }

    public String getTotalQuestions(String username) throws ExecutionException, InterruptedException
    {
        return new RetrieveCountTask().execute(new HttpRequest(new Endpoint(String.format("/questionAnswer.php?totalQuestions=%s", username)))).get();
    }

    @Override
    public Collection getAll() {
        return new FilterCollection(questionAnswerCollection, questionAnswer -> questionAnswer.questionAnswerId() > 0).getCollection();
    }
}
