package de.cbc.azubiproject.repositories;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
    private Collection<UserSession> userSessionCollection;
    private Gson gson;

    public UserSessionRepository(Collection<UserSession> userSessionCollection)
    {
        //this.userSessionCollection = (Collection<UserSession>) getAll();
        this.gson = new Gson();
    }

    @Override
    public Object getById(int id) {
        return new FilterCollection(userSessionCollection, userSession -> userSession.getUserSessionId() == id);
    }

    @Override
    public Collection getAll() {
        return new UserSessionResponse(new HttpRequest(new Endpoint("/userSessions.php")), new ArrayList<UserSession>()).getCollection();
    }

    @Override
    public Collection<UserSession> getByUserId(int id) {
        return new FilterCollection(userSessionCollection, userSession -> userSession.getUser().getUserId() == id).getCollection();
    }

    @Override
    public UserSessionCollection getRepositories() {
        return null;
    }

    public boolean login(String username, String password)
    {
        String json = null;
        int statusCode = 0;
        try {
            json = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
            json = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);
            HttpResponse httpResponse = new HttpRequest(new Endpoint("/login.php")).postRequest(json);
            statusCode = Integer.parseInt(httpResponse.getStatusCode());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return statusCode != 1002 && statusCode != 3001 && statusCode != 2001 && statusCode == 1001;
    }

    public boolean isSessionActive(String username)
    {
        UserSession session = (UserSession) new FilterCollection(userSessionCollection, userSession -> userSession.getUser().getUsername().equals(username)).getCollection().toArray()[0];

        if (session.getSession().isSessionActive()) {
            login(session.getUser().getUsername(), session.getUser().getPassword());

            return true;
        }

        return false;
    }

    public boolean register(IUser user, IProfile profile) {
        User myUser = new User(0, user.getUsername(), user.getPassword(), null, new Date().toString(), new Profile(0, profile.getFirstName(), profile.getLastName(), profile.getEmail(), profile.getBirthDate()));
        String json = gson.toJson(myUser);
        HttpResponse httpResponse = new HttpRequest(new Endpoint("/register.php")).postRequest(json);
        int statusCode = Integer.parseInt(httpResponse.getStatusCode());

        return statusCode != 3002 && statusCode != 4001 && statusCode != 5001 && statusCode == 1003;
    }
}
