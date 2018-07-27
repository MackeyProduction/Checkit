package de.cbc.azubiproject.interfaces;

import java.util.Collection;

import de.cbc.azubiproject.collections.QuestionAnswerCollection;
import de.cbc.azubiproject.models.QuestionAnswer;

public interface IQuestionAnswerRepository {
    public Object getById(int id);
    public Collection getAll();
}
