package de.cbc.azubiproject.checkit;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.models.AddGroupDialog;
import de.cbc.azubiproject.models.QuestionAnswer;

public class GroupViewActivity extends AppCompatActivity {

    private boolean pressedOnce;
    private boolean loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.checkit_action_bar);
        View view = getSupportActionBar().getCustomView();

        // set login state
        loggedIn = getIntent().getBooleanExtra(LoginActivity.LOGIN_STATE, false);

        if (loggedIn) {
            setContentView(R.layout.activity_group_view);
        } else {
            GroupFacade groupFacade = new GroupFacade();
            Collection<QuestionAnswer> questionAnswerCollection = groupFacade.getContainer().getQuestionAnswerCollection().getByGroupId(1);

            // testing groups
            for (int i = 0; i < questionAnswerCollection.size(); i++) {
                System.out.println(questionAnswerCollection.iterator().next().isCorrect());
            }

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            if (!pressedOnce) {
                pressedOnce = true;
                Toast.makeText(this, "Erneut drücken, um die App zu beenden.", Toast.LENGTH_LONG).show();

                // Führt erst innerhalb des Intervals die Runnable-Klasse als Callback aus
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pressedOnce = false;
                    }
                }, 3000);
            } else {
                pressedOnce = false;
                onBackPressed();
            }

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    public void btnGroup_onClick(View view)
    {
        Intent intent = new Intent(this, GroupActivity.class);
        startActivity(intent);
    }

    public void btnAddGroup_onClick(View view)
    {
        AddGroupDialog dialog = new AddGroupDialog(this, R.layout.dialog_group);
        dialog.showDialog();
    }
}
