package de.cbc.azubiproject.models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

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

    public boolean checkInternetConnection()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "Es konnte keine Verbindung zum Internet aufgebaut werden.", Toast.LENGTH_LONG).show();
        }

        return false;
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
