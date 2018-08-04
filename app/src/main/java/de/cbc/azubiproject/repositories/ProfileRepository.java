package de.cbc.azubiproject.repositories;

import com.android.internal.util.Predicate;

import java.util.Collection;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.RetrieveProfileTask;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.ProfileResponse;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.models.Profile;

public class ProfileRepository implements IRepository {
    private static Collection<Profile> profileCollection = null;
    private static ProfileRepository profileRepository = null;

    public ProfileRepository(Collection<Profile> profiles) {
        profileCollection = profiles;
    }

    public static ProfileRepository getInstance() throws ExecutionException, InterruptedException {
        if (profileRepository == null) {
            profileRepository = new ProfileRepository(new RetrieveProfileTask().execute(new ProfileResponse(new HttpRequest(new Endpoint("/profiles.php")), profileCollection)).get());
        }
        return profileRepository;
    }

    @Override
    public Object getById(final int id) {
        return new FilterCollection(profileCollection, profile -> profile.getProfileId() == id);
    }

    @Override
    public <T> Collection<T> getAll() {
        return new FilterCollection(profileCollection, profile -> profile.getProfileId() > 0).getCollection();
    }
}
