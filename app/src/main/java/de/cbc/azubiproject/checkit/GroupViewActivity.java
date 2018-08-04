package de.cbc.azubiproject.checkit;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.models.ActionBarHelper;
import de.cbc.azubiproject.models.ActionBarNoBackButton;
import de.cbc.azubiproject.models.AddGroupDialog;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;
import okhttp3.internal.http2.ConnectionShutdownException;

public class GroupViewActivity extends ActionBarNoBackButton {

    private boolean pressedOnce;
    private boolean loggedIn;
    private String username;
    private ConstraintLayout constraintLayout;
    private ConstraintSet constraintSet;
    private TextView textViewHeadline, textViewSubline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set login state
        loggedIn = getIntent().getBooleanExtra(LoginActivity.LOGIN_STATE, false);
        //username = getIntent().getStringExtra(LoginActivity.USERNAME);

        constraintSet = new ConstraintSet();

        if (loggedIn && checkInternetConnection()) {
            setContentView(R.layout.activity_group_view);

            try {
                GroupContainer groupContainer = new GroupFacade().getContainer();

                List<UserGroup> userGroups = (List<UserGroup>)groupContainer.getUserGroupCollection().getByUsername("vorbrugg");

                textViewHeadline = (TextView) findViewById(R.id.textViewGroupHeadline);
                textViewSubline = (TextView) findViewById(R.id.textViewGroupSubline);

                textViewHeadline.setText(userGroups.get(0).getGroup().getGroupName());
                textViewSubline.setText(userGroups.get(0).getUser().getUsername());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }


            // listing groups
            /*for (int i = 0; i < userGroups.size(); i++) {
                int id = View.generateViewId();
                int startId = View.generateViewId();
                int endId = View.generateViewId();

                constraintLayout = (ConstraintLayout) findViewById(R.id.constraintGroupView);

                ImageView imageViewBackground = new ImageView(this);
                imageViewBackground.setId(startId);
                imageViewBackground.setMinimumHeight(R.dimen.groupView_card_minHeight);
                imageViewBackground.setMinimumWidth(R.dimen.groupView_card_minWidth);
                imageViewBackground.setImageResource(R.drawable.rounded_edittext);
                constraintLayout.addView(imageViewBackground);

                ConstraintLayout.LayoutParams clpImageView = new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                imageViewBackground.setLayoutParams(clpImageView);

                constraintSet.clone(constraintLayout);

                constraintSet.connect(startId, ConstraintSet.TOP, endId, ConstraintSet.BOTTOM, 16);
                constraintSet.connect(startId, ConstraintSet.START, id, ConstraintSet.END, 16);

                constraintSet.applyTo(constraintLayout);
            }*/
        } else {
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
