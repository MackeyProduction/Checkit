package de.cbc.azubiproject.interfaces;

import java.util.Collection;

public interface IResponseRepository {
    public Object getById(int id);
    public Collection getAll();
}
