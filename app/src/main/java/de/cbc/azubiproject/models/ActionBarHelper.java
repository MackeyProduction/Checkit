package de.cbc.azubiproject.models;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import de.cbc.azubiproject.checkit.ProfileActivity;
import de.cbc.azubiproject.checkit.R;

public class ActionBarHelper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy_layout);
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
