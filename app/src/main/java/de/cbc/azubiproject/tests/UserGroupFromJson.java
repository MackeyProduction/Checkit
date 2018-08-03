package de.cbc.azubiproject.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.Collection;
import java.util.List;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.models.Profile;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.UserGroupRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public class UserGroupFromJson {
    public static void main(String[] args)
    {
        /*GroupContainer groupContainer = new GroupFacade().getContainer();
        List<UserGroup> userGroups = (List<UserGroup>)groupContainer.getUserGroupCollection().getByUsername("vorbrugg");

        UserRepository userRepository = groupContainer.getUserGroupCollection().getRepositories().getUserRepository();
        Collection<User> a = userRepository.getAll();

        System.out.println(userRepository.getByUsername("anheier").getUserId());
        System.out.println(userGroups.get(0).getUserGroupId());*/
    }
}
