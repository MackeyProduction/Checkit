package de.cbc.azubiproject.checkit;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.models.AddGroupDialog;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupViewFragment extends Fragment implements View.OnClickListener {
    private boolean pressedOnce;
    private boolean loggedIn;
    private String username;
    private ConstraintLayout constraintLayout;
    private ConstraintSet constraintSet;
    private TextView textViewHeadline, textViewSubline;
    public static final String GROUP_ID = "de.cbc.checkit.MESSAGE";
    private GroupContainer groupContainer;
    private List<UserGroup> userGroups;

    public GroupViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_group_view, container, false);

        textViewHeadline = (TextView) layout.findViewById(R.id.textViewGroupHeadline);
        textViewSubline = (TextView) layout.findViewById(R.id.textViewGroupSubline);

        // buttons
        FloatingActionButton btnFabAddGroup = (FloatingActionButton) layout.findViewById(R.id.fabAddGroup);
        btnFabAddGroup.setOnClickListener(this);
        ImageView imageViewGroup = (ImageView) layout.findViewById(R.id.imageViewGroup);
        imageViewGroup.setOnClickListener(this);

        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String username = getArguments().getString(MainActivity.LOGIN_STATE);

        if (!TextUtils.isEmpty(username)) {
            try {
                groupContainer = new GroupFacade().getContainer();

                userGroups = (List<UserGroup>)groupContainer.getUserGroupCollection().getByUsername(username);

                textViewHeadline.setText(userGroups.get(0).getGroup().getGroupName());
                textViewSubline.setText(userGroups.get(0).getUser().getUsername());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                Toast.makeText(getActivity().getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void btnGroup_onClick(View view)
    {
        Bundle bundle = new Bundle();
        bundle.putString(GROUP_ID, Integer.toString(userGroups.get(0).getGroup().getGroupId()));
        GroupFragment groupFragment = (GroupFragment) Fragment.instantiate(getActivity().getApplicationContext(), GroupFragment.class.getName(), bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.clMain, groupFragment);
        fragmentTransaction.commit();
    }

    public void btnAddGroup_onClick(View view)
    {
        AddGroupDialog dialog = new AddGroupDialog(getActivity(), R.layout.dialog_group);
        dialog.showDialog();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabAddGroup:
                btnAddGroup_onClick(view);
                break;
            case R.id.imageViewGroup:
                btnGroup_onClick(view);
                break;
        }
    }
}
