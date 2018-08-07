package de.cbc.azubiproject.checkit;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.UserRegisterTask;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.http.StatusCodes;
import de.cbc.azubiproject.models.Profile;
import de.cbc.azubiproject.models.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {
    private TextView registerHeader;
    private String username, password, passwordRepeat, firstName, lastName, email, birthDate;
    private EditText usernameEditText, passwordEditText, passwordRepeatEditText, firstNameEditText, lastNameEditText, emailEditText, birthDateEditText;
    private GroupViewFragment groupViewFragment;
    private GroupFragment groupFragment;
    private QuestionModeFragment questionModeFragment;
    private ProfileFragment profileFragment;
    public static final String LOGIN_STATE = "de.cbc.checkit.MESSAGE";

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_register, container, false);

        registerHeader = (TextView) layout.findViewById(R.id.textViewRegister);
        Typeface ubuntu = Typeface.createFromAsset(getActivity().getAssets(), "font/Ubuntu-R.ttf");
        registerHeader.setTypeface(ubuntu);

        // edittext
        usernameEditText = (EditText) layout.findViewById(R.id.editTextUsername);
        passwordEditText = (EditText) layout.findViewById(R.id.editTextPassword);
        passwordRepeatEditText = (EditText) layout.findViewById(R.id.editTextRepeatPassword);
        firstNameEditText = (EditText) layout.findViewById(R.id.editTextFirstname);
        lastNameEditText = (EditText) layout.findViewById(R.id.editTextLastname);
        emailEditText = (EditText) layout.findViewById(R.id.editTextEmail);
        birthDateEditText = (EditText) layout.findViewById(R.id.editTextBirthdate);

        // initiate button
        Button btnRegister = (Button) layout.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        // Inflate the layout for this fragment
        return layout;
    }

    public void btnRegister_onClick(View view)
    {
        try {
            username = usernameEditText.getText().toString();
            password = passwordEditText.getText().toString();
            passwordRepeat = passwordRepeatEditText.getText().toString();
            firstName = firstNameEditText.getText().toString();
            lastName = lastNameEditText.getText().toString();
            email = emailEditText.getText().toString();
            birthDate = birthDateEditText.getText().toString();

            if (!username.equals("") || !password.equals("") || !passwordRepeat.equals("") || !firstName.equals("") || !lastName.equals("") || !email.equals("") || !birthDate.equals("")) {
                if (password.equals(passwordRepeat)) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                    if (isValidDate(format, birthDate)) {
                        HttpResponse response = new UserRegisterTask().execute(new User(0, username, password, null, null, new Profile(0, firstName, lastName, email, birthDate))).get();
                        int statusCode = Integer.parseInt(response.getStatusCode());

                        if (statusCode == StatusCodes.REGISTER_SUCCESSFUL) {
                            Toast.makeText(getActivity().getApplicationContext(), response.getStatusMessage(), Toast.LENGTH_LONG).show();

                            // create bundle
                            Bundle bundle = new Bundle();
                            bundle.putString(LOGIN_STATE, usernameEditText.getText().toString());
                            groupViewFragment = (GroupViewFragment) Fragment.instantiate(getActivity(), GroupViewFragment.class.getName(), bundle);
                            groupFragment = (GroupFragment) Fragment.instantiate(getActivity(), GroupFragment.class.getName(), bundle);
                            questionModeFragment = (QuestionModeFragment) Fragment.instantiate(getActivity(), QuestionModeFragment.class.getName(), bundle);
                            profileFragment = (ProfileFragment) Fragment.instantiate(getActivity(), ProfileFragment.class.getName(), bundle);

                            // redirect to fragment
                            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.clMain, groupViewFragment);
                            fragmentTransaction.commit();
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), response.getStatusMessage(), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "Das Geburtsdatum muss im Format: yyyy-MM-dd sein. (z.B. 1995-06-25)", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Die Passwörter stimmen nicht überein.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Es sind nicht alle Textfelder ausgefüllt.", Toast.LENGTH_LONG).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
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

    @Override
    public void onClick(View view) {
        btnRegister_onClick(view);
    }
}
