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
public class RegisterFragment extends Fragment {
    public static final String LOGIN_STATE = "de.cbc.checkit.MESSAGE";

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }
}
