package de.cbc.azubiproject.checkit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.UserRegisterTask;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.http.StatusCodes;
import de.cbc.azubiproject.models.Profile;
import de.cbc.azubiproject.models.User;

public class RegisterActivity extends AppCompatActivity {
    private TextView registerHeader;
    private String username, password, passwordRepeat, firstName, lastName, email, birthDate;
    public static final String LOGIN_STATE = "de.cbc.checkit.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerHeader = (TextView) findViewById(R.id.textViewRegister);
        Typeface ubuntu = Typeface.createFromAsset(getAssets(), "font/Ubuntu-R.ttf");
        registerHeader.setTypeface(ubuntu);
    }

    public void btnRegister_onClick(View view)
    {
        username = ((EditText) findViewById(R.id.editTextUsername)).getText().toString();
        password = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();
        passwordRepeat = ((EditText) findViewById(R.id.editTextRepeatPassword)).getText().toString();
        firstName = ((EditText) findViewById(R.id.editTextFirstname)).getText().toString();
        lastName = ((EditText) findViewById(R.id.editTextLastname)).getText().toString();
        email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();
        birthDate = ((EditText) findViewById(R.id.editTextBirthdate)).getText().toString();

        try {
            if (!username.equals("") || !password.equals("") || !passwordRepeat.equals("") || !firstName.equals("") || !lastName.equals("") || !email.equals("") || !birthDate.equals("")) {
                if (password.equals(passwordRepeat)) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                    if (isValidDate(format, birthDate)) {
                        HttpResponse response = new UserRegisterTask().execute(new User(0, username, password, null, null, new Profile(0, firstName, lastName, email, birthDate))).get();
                        int statusCode = Integer.parseInt(response.getStatusCode());

                        if (statusCode == StatusCodes.REGISTER_SUCCESSFUL) {
                            Toast.makeText(getApplicationContext(), response.getStatusMessage(), Toast.LENGTH_LONG).show();

                            // redirect to group view
                            Intent intent = new Intent(getApplicationContext(), GroupViewActivity.class);
                            intent.putExtra(LOGIN_STATE, true);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), response.getStatusMessage(), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Das Geburtsdatum muss im Format: yyyy-MM-dd sein. (z.B. 1995-06-25)", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Die Passwörter stimmen nicht überein.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Es sind nicht alle Textfelder ausgefüllt.", Toast.LENGTH_LONG).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    boolean isValidDate(SimpleDateFormat format, String input) {
        try {
            format.parse(input);
            return true;
        }
        catch(ParseException e){
            return false;
        }
    }
}
