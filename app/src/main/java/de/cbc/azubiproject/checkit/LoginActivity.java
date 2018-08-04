package de.cbc.azubiproject.checkit;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.UserLoginTask;
import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.http.StatusCodes;
import de.cbc.azubiproject.repositories.UserSessionRepository;

public class LoginActivity extends AppCompatActivity {

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
    public static final String USERNAME = "de.cbc.checkit.MESSAGE";

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

    public void btnLogin_onClick(View view) throws ExecutionException, InterruptedException {
        btnLogin = findViewById(R.id.btnLogin);
        editTextUsername = findViewById(R.id.editTextBirthdate);
        editTextPassword = findViewById(R.id.editTextPassword);

        httpResponse = new UserLoginTask().execute(editTextUsername.getText().toString(), editTextPassword.getText().toString()).get();
        statusCode = Integer.parseInt(httpResponse.getStatusCode());
        responseMessage = httpResponse.getStatusMessage();

        if (statusCode == StatusCodes.LOGIN_SUCCESSFUL) {
            Toast.makeText(getApplicationContext(), "Erfolgreich eingeloggt.", Toast.LENGTH_LONG).show();

            // redirect to activity
            Intent intent = new Intent(getApplicationContext(), GroupViewActivity.class);
            intent.putExtra(LOGIN_STATE, true);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), responseMessage, Toast.LENGTH_LONG).show();
        }
    }

    public void btnRegister_onClick(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
