package de.cbc.azubiproject.interfaces;

import com.android.internal.util.Predicate;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractFilterCollection {
    private Collection collection;
    private Predicate predicate;

    public <T> AbstractFilterCollection(Collection<T> collection, Predicate<T> predicate)
    {
        this.collection = collection;
        this.predicate = predicate;
    }

    public <T> Collection<T> getCollection()
    {
        return filter(collection, predicate);
    }

    protected abstract <T> Collection<T> filter(Collection<T> collection, Predicate<T> predicate);
}
