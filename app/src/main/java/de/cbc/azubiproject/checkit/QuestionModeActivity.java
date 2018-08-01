package de.cbc.azubiproject.checkit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.cbc.azubiproject.models.ActionBarHelper;

public class QuestionModeActivity extends ActionBarHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_mode);
    }
}
