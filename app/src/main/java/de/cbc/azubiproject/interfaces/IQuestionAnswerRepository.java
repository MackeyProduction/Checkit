package de.cbc.azubiproject.interfaces;

import java.util.Collection;

import de.cbc.azubiproject.models.QuestionAnswer;

public interface IQuestionAnswerRepository extends IResponseRepository {
    public Collection<QuestionAnswer> getByGroupId(int groupId);
}
