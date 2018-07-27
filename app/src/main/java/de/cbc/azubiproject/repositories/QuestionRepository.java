package de.cbc.azubiproject.repositories;

import java.util.Collection;

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
        return null;
    }

    @Override
    public <T> Collection<T> getAll() {
        return null;
    }
}
