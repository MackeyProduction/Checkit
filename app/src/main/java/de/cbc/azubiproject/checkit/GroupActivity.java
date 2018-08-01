package de.cbc.azubiproject.checkit;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GroupActivity extends AppCompatActivity {

    private TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.checkit_action_bar_back_button);
        View view = getSupportActionBar().getCustomView();

        questionTextView = (TextView) findViewById(R.id.textViewQuestion);
        Typeface ubuntu = Typeface.createFromAsset(getAssets(), "font/Ubuntu-R.ttf");
        questionTextView.setTypeface(ubuntu);
    }
}
