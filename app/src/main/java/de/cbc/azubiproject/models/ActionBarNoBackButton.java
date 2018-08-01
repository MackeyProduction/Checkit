package de.cbc.azubiproject.models;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;

import de.cbc.azubiproject.checkit.R;

public class ActionBarNoBackButton extends ActionBarHelper {
    @Override
    protected void build(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.checkit_action_bar);
        View view = getSupportActionBar().getCustomView();
    }
}
