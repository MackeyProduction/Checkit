package de.cbc.azubiproject.checkit;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.UserLoginTask;
import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.http.StatusCodes;

public class MainActivity extends FragmentActivity {
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;
    private GroupViewFragment groupViewFragment;
    private GroupFragment groupFragment;
    private QuestionModeFragment questionModeFragment;
    private ProfileFragment profileFragment;

    private boolean pressedOnce;
    private Button btnLogin;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private boolean loggedIn = false;
    private TextView forgetPassword;
    private HttpResponse httpResponse;
    private int statusCode;
    private String json, responseMessage;
    private Gson gson = new Gson();
    public static final String LOGIN_STATE = "de.cbc.checkit.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = (LoginFragment) Fragment.instantiate(this, LoginFragment.class.getName(), null);
        registerFragment = (RegisterFragment) Fragment.instantiate(this, RegisterFragment.class.getName(), null);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.clMain, loginFragment);
        fragmentTransaction.commit();
    }

    public void btnMenuProfile_onClick(View view) {
        replaceFragment(profileFragment);
    }

    public void btnMenuBack_onClick(View view) {
        onBackPressed();
    }

    public void btnRegisterView_onClick(View view) {
        replaceFragment(registerFragment);
    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.clMain, fragment);
        fragmentTransaction.commit();
    }

    public void btnLogin_onClick(View view) throws ExecutionException, InterruptedException {
        btnLogin = findViewById(R.id.btnLogin);
        editTextUsername = findViewById(R.id.editTextBirthdate);
        editTextPassword = findViewById(R.id.editTextPassword);

        httpResponse = new UserLoginTask().execute(editTextUsername.getText().toString(), editTextPassword.getText().toString()).get();
        statusCode = Integer.parseInt(httpResponse.getStatusCode());
        responseMessage = httpResponse.getStatusMessage();

        if (statusCode == StatusCodes.LOGIN_SUCCESSFUL && checkInternetConnection()) {
            Toast.makeText(view.getContext(), "Erfolgreich eingeloggt.", Toast.LENGTH_LONG).show();

            // create bundle
            Bundle bundle = new Bundle();
            bundle.putString(LOGIN_STATE, editTextUsername.getText().toString());
            groupViewFragment = (GroupViewFragment) Fragment.instantiate(this, GroupViewFragment.class.getName(), bundle);
            groupFragment = (GroupFragment) Fragment.instantiate(this, GroupFragment.class.getName(), bundle);
            questionModeFragment = (QuestionModeFragment) Fragment.instantiate(this, QuestionModeFragment.class.getName(), bundle);
            profileFragment = (ProfileFragment) Fragment.instantiate(this, ProfileFragment.class.getName(), bundle);

            // redirect to activity
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.clMain, groupViewFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(view.getContext(), responseMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (groupViewFragment != null) {
            if (groupViewFragment.isVisible()) {
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
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    public boolean checkInternetConnection()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                return true;
            } else {
                Toast.makeText(getApplicationContext(), "Es konnte keine Verbindung zum Internet aufgebaut werden.", Toast.LENGTH_LONG).show();
            }
        }

        return false;
    }
}
