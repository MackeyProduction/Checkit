package de.cbc.azubiproject.repositories;

import com.android.internal.util.Predicate;

import java.util.Collection;

import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.Profile;

public class ProfileRepository implements IRepository {
    private Collection<Profile> profileCollection;

    public ProfileRepository(Collection<Profile> profileCollection)
    {
        this.profileCollection = profileCollection;
    }

    @Override
    public Object getById(final int id) {
        return new FilterCollection(profileCollection, new Predicate<Profile>() {
            @Override
            public boolean apply(Profile profile) {
                return profile.getProfileId() == id;
            }
        });
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(profileCollection, new Predicate<Profile>() {
            @Override
            public boolean apply(Profile profile) {
                return profile.getProfileId() > 0;
            }
        }).getCollection();
    }
}
