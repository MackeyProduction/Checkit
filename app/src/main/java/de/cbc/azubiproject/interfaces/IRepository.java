package de.cbc.azubiproject.interfaces;

import java.util.Collection;

public interface IRepository {
    public Object getById(int id);
    public <T> Collection<T> getAll();
}
