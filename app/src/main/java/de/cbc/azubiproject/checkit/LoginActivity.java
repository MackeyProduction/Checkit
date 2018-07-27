package de.cbc.azubiproject.checkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

import de.cbc.azubiproject.collections.UserCollection;
import de.cbc.azubiproject.interfaces.IUser;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private boolean loggedIn = true;
    public static final String LOGIN_STATE = "de.cbc.checkit.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (loggedIn) {
            Intent intent = new Intent(this, GroupViewActivity.class);
            intent.putExtra(LOGIN_STATE, true);
            startActivity(intent);
        }
    }

    public void btnLogin_onClick(View view)
    {
        btnLogin = findViewById(R.id.btnLogin);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        if (editTextUsername.getText().toString().equals("foo") && editTextPassword.getText().toString().equals("bar")) {
            Toast.makeText(getApplicationContext(), "Erfolgreich eingeloggt.", Toast.LENGTH_LONG).show();

            // redirect to activity
            Intent intent = new Intent(this, GroupViewActivity.class);
            intent.putExtra(LOGIN_STATE, true);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Login leider nicht erfolgreich.", Toast.LENGTH_LONG).show();
        }
    }
}
