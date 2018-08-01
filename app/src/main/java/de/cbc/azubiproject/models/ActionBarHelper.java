package de.cbc.azubiproject.models;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import de.cbc.azubiproject.checkit.ProfileActivity;
import de.cbc.azubiproject.checkit.R;
import de.cbc.azubiproject.interfaces.AbstractActivityHelper;

public class ActionBarHelper extends AbstractActivityHelper {

    @Override
    protected void build(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.checkit_action_bar_back_button);
        View view = getSupportActionBar().getCustomView();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        build(savedInstanceState);
    }

    public void btnProfile_onClick(View view)
    {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void btnBack_onClick(View view)
    {
        onBackPressed();
    }
}
