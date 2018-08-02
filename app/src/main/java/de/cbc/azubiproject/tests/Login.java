package de.cbc.azubiproject.tests;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;

public class Login {
    public static void main(String[] args)
    {
        GroupContainer groupContainer = new GroupFacade().getContainer();
        boolean login = groupContainer.getUserSessionCollection().login("anheier", "foobar");
        boolean sessionActive = groupContainer.getUserSessionCollection().isSessionActive("anheier");

        System.out.println(login);
        System.out.println(sessionActive);
    }
}
