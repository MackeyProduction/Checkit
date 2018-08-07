package de.cbc.azubiproject.interfaces;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.collections.QuestionAnswerCollection;
import de.cbc.azubiproject.models.QuestionAnswer;

public interface IQuestionAnswerRepository extends IResponseRepository {
    public Collection<QuestionAnswer> getByGroupId(int groupId) throws InterruptedException, ExecutionException;
    public Collection<QuestionAnswer> getByAnswerType(int groupId, String answerType) throws InterruptedException, ExecutionException;
}
