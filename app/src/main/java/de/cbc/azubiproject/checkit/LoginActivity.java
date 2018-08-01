package de.cbc.azubiproject.checkit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private boolean loggedIn = false;
    private TextView forgetPassword;
    public static final String LOGIN_STATE = "de.cbc.checkit.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgetPassword = (TextView) findViewById(R.id.textViewForgetPassword);
        Typeface ubuntu = Typeface.createFromAsset(getAssets(), "font/Ubuntu-R.ttf");
        forgetPassword.setTypeface(ubuntu);

        if (loggedIn) {
            Intent intent = new Intent(this, GroupViewActivity.class);
            intent.putExtra(LOGIN_STATE, true);
            startActivity(intent);
        }
    }

    public void btnLogin_onClick(View view)
    {
        btnLogin = findViewById(R.id.btnLogin);
        editTextUsername = findViewById(R.id.editTextBirthdate);
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

    public void btnRegister_onClick(View view)
    {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
