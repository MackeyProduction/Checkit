package de.cbc.azubiproject.checkit;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.containers.RepositoryContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.models.ActionBarHelper;
import de.cbc.azubiproject.models.User;

public class ProfileActivity extends ActionBarHelper {
    private TextView textViewUsername, textViewAskedQuestions, textViewAskedQuestionsString, textViewRegisteredSince, textViewRegisteredSinceString, textViewActiveGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Typeface ubuntu = Typeface.createFromAsset(getAssets(), "font/Ubuntu-R.ttf");

        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewAskedQuestions = (TextView) findViewById(R.id.textViewAskedQuestions);
        textViewAskedQuestionsString = (TextView) findViewById(R.id.textViewAskedQuestionsString);
        textViewRegisteredSince = (TextView) findViewById(R.id.textViewRegisteredSince);
        textViewRegisteredSinceString = (TextView) findViewById(R.id.textViewRegisteredSinceString);
        textViewActiveGroups = (TextView) findViewById(R.id.textViewActiveGroups);

        textViewUsername.setTypeface(ubuntu);
        textViewAskedQuestions.setTypeface(ubuntu);
        textViewAskedQuestionsString.setTypeface(ubuntu);
        textViewRegisteredSince.setTypeface(ubuntu);
        textViewRegisteredSinceString.setTypeface(ubuntu);
        textViewActiveGroups.setTypeface(ubuntu);

        try {
            // load user data
            RepositoryContainer repositoryContainer = new GroupFacade().getRepositories();
            User user = repositoryContainer.getUserGroupCollection().getUserRepository().getByUsername("anheier");

            // set profile
            textViewUsername.setText(user.getProfile().getFirstName());
            textViewRegisteredSinceString.setText(user.getRegisterDate());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
