package de.cbc.azubiproject.tests;

import de.cbc.azubiproject.http.Endpoint;
import de.cbc.azubiproject.http.HttpRequest;
import de.cbc.azubiproject.http.HttpResponse;

public class AddQuestion {
    public static void main(String[] args) {
        String username = "anheier";
        String groupName = "Mathe-Vorbereitung";
        String question = "Was ist eine Hypotenuse?";
        String answer = "Als Hypotenuse bezeichnet man die laengste Seite eines rechtwinkligen Dreiecks. Sie liegt dem rechten Winkel gegenueber.";
        String answerType = "1";
        String correct = "1";

        String json = String.format("{\"username\":\"%s\",\"groupname\":\"%s\",\"question\":\"%s\",\"answer\":\"%s\",\"answerType\":\"%s\",\"correct\":\"%s\"}", username, groupName, question, answer, answerType, correct);
        HttpResponse httpResponse = new HttpRequest(new Endpoint("/questionAnswer.php")).postRequest(json);
        int statusCode = Integer.parseInt(httpResponse.getStatusCode());

        System.out.println(statusCode);
        System.out.println(httpResponse.getResponse() != null);
    }
}
