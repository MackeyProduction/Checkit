package de.cbc.azubiproject.tests;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import de.cbc.azubiproject.models.Group;
import de.cbc.azubiproject.models.Profile;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.GroupRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public class UserGroupToJson {
    public static void main(String[] args)
    {
        Collection<User> userCollection = new ArrayList<User>();
        Collection<Group> groupCollection = new ArrayList<Group>();
        Collection<UserGroup> userGroupCollection = new ArrayList<UserGroup>();
        Gson gson = new Gson();

        User[] users = new User[] {
                new User(1, "anheier", "123456", "abcdef", "2018-08-01 00:00:00", new Profile(1, "Til", "Anheier", "til.anheier@cbc.de", "07.09.1996")),
                new User(2, "vorbrugg", "foobar", "ghijklmn", "2018-07-25 12:00:00", new Profile(2, "Christin", "Vorbrugg", "christin.vorbrugg@rtl.de", "01.01.1997")),
                new User(3, "woll", "woll123", "opqrstuvw", "2018-07-08 11:00:00", new Profile(3, "Tim", "Woll", "tim.woll@cbc.de", "01.01.1996"))
        };

        Group[] groups = new Group[] {
                new Group(1, "Mathe Klausur"),
                new Group(2, "Geschichtstest"),
                new Group(3, "Biologie-Lerngruppe")
        };

        UserGroup[] userGroups = new UserGroup[] {
                new UserGroup(1, users[0], groups[0]),
                new UserGroup(2, users[1], groups[0]),
                new UserGroup(3, users[1], groups[1]),
                new UserGroup(4, users[2], groups[1]),
                new UserGroup(5, users[0], groups[2]),
                new UserGroup(6, users[2], groups[2])
        };

        // adding elements to collection
        userCollection.addAll(Arrays.asList(users));
        groupCollection.addAll(Arrays.asList(groups));
        userGroupCollection.addAll(Arrays.asList(userGroups));

        // creating repositories
        //UserRepository userRepository = new UserRepository(userCollection);
        GroupRepository groupRepository = new GroupRepository(groupCollection);
        UserGroupRepository userGroupRepository = new UserGroupRepository(userGroupCollection);

        // convert to json
        String json = gson.toJson(userGroupRepository);

        UserGroup userGroup = (UserGroup) userGroupRepository.getById(1);

        System.out.println(json);
        System.out.println(userGroup.getUser().getUsername());
    }
}
