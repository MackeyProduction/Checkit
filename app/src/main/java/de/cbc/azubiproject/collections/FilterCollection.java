package de.cbc.azubiproject.collections;

import com.android.internal.util.Predicate;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.interfaces.AbstractFilterCollection;

public class FilterCollection extends AbstractFilterCollection {
    public <T> FilterCollection(Collection<T> collection, Predicate<T> predicate) {
        super(collection, predicate);
    }

    @Override
    protected <T> Collection<T> filter(Collection<T> collection, Predicate<T> predicate) {
        Collection<T> result = new ArrayList<T>();
        for (T element: collection) {
            if (predicate.apply(element)) {
                result.add(element);
            }
        }

        return result;
    }
}
