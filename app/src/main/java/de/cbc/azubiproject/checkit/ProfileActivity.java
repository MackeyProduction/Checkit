package de.cbc.azubiproject.checkit;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.cbc.azubiproject.models.ActionBarHelper;

public class ProfileActivity extends ActionBarHelper {
    private TextView textViewUsername, textViewAskedQuestions, textViewAskedQuestionsSince, textViewRegisteredSince, textViewRegisteredSinceString, textViewActiveGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Typeface ubuntu = Typeface.createFromAsset(getAssets(), "font/Ubuntu-R.ttf");

        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewAskedQuestions = (TextView) findViewById(R.id.textViewAskedQuestions);
        textViewAskedQuestionsSince = (TextView) findViewById(R.id.textViewAskedQuestionsString);
        textViewRegisteredSince = (TextView) findViewById(R.id.textViewRegisteredSince);
        textViewRegisteredSinceString = (TextView) findViewById(R.id.textViewRegisteredSinceString);
        textViewActiveGroups = (TextView) findViewById(R.id.textViewActiveGroups);

        textViewUsername.setTypeface(ubuntu);
        textViewAskedQuestions.setTypeface(ubuntu);
        textViewAskedQuestionsSince.setTypeface(ubuntu);
        textViewRegisteredSince.setTypeface(ubuntu);
        textViewRegisteredSinceString.setTypeface(ubuntu);
        textViewActiveGroups.setTypeface(ubuntu);
    }
}
