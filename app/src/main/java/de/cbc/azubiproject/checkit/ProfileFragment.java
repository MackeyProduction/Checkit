package de.cbc.azubiproject.checkit;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.containers.RepositoryContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.models.User;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.GroupRepository;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private String username;
    private TextView textViewFirstName, textViewRegisterDate;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_profile, container, false);

        textViewFirstName = (TextView) layout.findViewById(R.id.textViewUsername);
        textViewRegisterDate = (TextView) layout.findViewById(R.id.textViewRegisteredSinceString);

        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        username = getArguments().getString(MainActivity.LOGIN_STATE);

        if (!TextUtils.isEmpty(username)) {
            try {
                RepositoryContainer groupContainer = new GroupFacade().getRepositories();
                User user = groupContainer.getUserSessionCollection().getUserRepository().getByUsername(username);

                textViewFirstName.setText(user.getProfile().getFirstName());
                textViewRegisterDate.setText(user.getRegisterDate());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
