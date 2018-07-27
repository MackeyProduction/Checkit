package de.cbc.azubiproject.repositories;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.Answer;

public class AnswerRepository implements IRepository {
    private Collection<Answer> answerCollection;

    public AnswerRepository(Collection<Answer> answerCollection)
    {
        this.answerCollection = answerCollection;
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
