package de.cbc.azubiproject.interfaces;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import de.cbc.azubiproject.checkit.R;

public abstract class AbstractActivityHelper extends AppCompatActivity {
    private int resourceId;
    private Bundle savedInstanceState;

    public AbstractActivityHelper()
    {
        this.resourceId = resourceId;
        this.savedInstanceState = savedInstanceState;
    }

    public void create()
    {
        build(savedInstanceState);
    }

    abstract protected void build(Bundle savedInstanceState);

    public int getResourceId() {
        return resourceId;
    }
}
