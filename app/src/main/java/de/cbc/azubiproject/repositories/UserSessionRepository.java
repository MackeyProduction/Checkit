package de.cbc.azubiproject.repositories;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.HttpPostTask;
import de.cbc.azubiproject.asynctasks.RetrieveUserSessionTask;
import de.cbc.azubiproject.collections.FilterCollection;
import de.cbc.azubiproject.collections.UserSessionCollection;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.http.UserSessionResponse;
import de.cbc.azubiproject.interfaces.IProfile;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.interfaces.IResponseRepository;
import de.cbc.azubiproject.interfaces.IUser;
import de.cbc.azubiproject.interfaces.IUserSessionRepository;
import de.cbc.azubiproject.models.Profile;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserSession;

public class UserSessionRepository implements IUserSessionRepository {
    private static Collection<UserSession> userSessionCollection;
    private static UserSessionRepository userSessionRepository;

    protected UserSessionRepository(Collection<UserSession> userSessions) {
        userSessionCollection = userSessions;
    }

    public static UserSessionRepository getInstance(boolean refresh) throws ExecutionException, InterruptedException
    {
        if (userSessionRepository == null || refresh) {
            userSessionRepository = new UserSessionRepository(new RetrieveUserSessionTask().execute(new UserSessionResponse(new HttpRequest(new Endpoint("/userSessions.php")), new ArrayList<UserSession>())).get());
        }
        return userSessionRepository;
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(userSessionCollection, userSession -> userSession.getUserSessionId() == id);
    }

    @Override
    public Collection getAll() {
        return userSessionCollection;
    }

    @Override
    public Collection<UserSession> getByUserId(int id) {
        return new FilterCollection(userSessionCollection, userSession -> userSession.getUser().getUserId() == id).getCollection();
    }

    public boolean login(String username, String password) throws ExecutionException, InterruptedException {
        String json = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);
        int statusCode = new HttpPostTask().execute(new HttpRequest(new Endpoint("/login.php")).postRequest(json)).get();

        return statusCode != 1002 && statusCode != 3001 && statusCode != 2001 && statusCode == 1001;
    }

    public boolean isSessionActive(String username) throws InterruptedException, ExecutionException {
        UserSession session = (UserSession) new FilterCollection(userSessionCollection, userSession -> userSession.getUser().getUsername().equals(username)).getCollection().toArray()[0];

        if (session.getSession().isSessionActive()) {
            login(session.getUser().getUsername(), session.getUser().getPassword());

            return true;
        }

        return false;
    }

    public boolean register(IUser user, IProfile profile) throws InterruptedException, ExecutionException {
        String json = String.format("{\"username\":\"%s\",\"password\":\"%s\",\"firstname\":\"%s\",\"lastname\":\"%s\",\"email\":\"%s\",\"birthDate\":\"%s\"}", user.getUsername(), user.getPassword(), user.getProfile().getFirstName(), user.getProfile().getLastName(), user.getProfile().getEmail(), user.getProfile().getBirthDate());
        int statusCode = new HttpPostTask().execute(new HttpRequest(new Endpoint("/register.php")).postRequest(json)).get();

        return statusCode != 3002 && statusCode != 4001 && statusCode != 5001 && statusCode == 1003;
    }
}
