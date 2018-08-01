package de.cbc.azubiproject.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.models.Profile;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;

public class UserGroupFromJson {
    public static void main(String[] args)
    {
        String json = new HttpRequest(new Endpoint("/group.php")).getRequest();

        Gson gson = new Gson();
        //List<UserGroup> userGroup = gson.fromJson(json, new TypeToken<List<UserGroup>>(){}.getType());
        User user = gson.fromJson("{'userId':'1','username':'anheier','password':'$5$11$0hpI86LSfvhS6fTn57B0QJ1xJgHYINArlw.tH5nGcx.','salt':'jZy7VP7bAGup2mgsLBDP','registerDate':'2018-07-29 00:00:00','Profile':{'profileId':'1','firstName':'Til','lastName':'Anheier','email':'til.anheier@cbc.de','birthDate':'1996-09-07'}}", User.class);

        //System.out.println(json);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getProfile().getProfileId());
    }
}
