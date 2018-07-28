package de.cbc.azubiproject.repositories;

import java.util.Collection;

import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.Question;

public class QuestionRepository implements IRepository {
    private Collection<Question> questionCollection;

    public QuestionRepository(Collection<Question> questionCollection)
    {
        this.questionCollection = questionCollection;
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(questionCollection, question -> question.getQuestionId() == id);
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(questionCollection, question -> question.getQuestionId() > 0).getCollection();
    }
}
