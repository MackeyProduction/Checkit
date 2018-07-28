package de.cbc.azubiproject.repositories;

import java.util.Collection;

import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.AnswerType;

public class AnswerTypeRepository implements IRepository {
    private Collection<AnswerType> answerTypeCollection;

    public AnswerTypeRepository(Collection<AnswerType> answerTypeCollection)
    {
        this.answerTypeCollection = answerTypeCollection;
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(answerTypeCollection, answerType -> answerType.getAnswerTypeId() == id);
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(answerTypeCollection, answerType -> answerType.getAnswerTypeId() > 0).getCollection();
    }
}
