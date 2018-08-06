package de.cbc.azubiproject.checkit;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class GroupViewFragment extends Fragment {
    private boolean pressedOnce;
    private boolean loggedIn;
    private String username;
    private ConstraintLayout constraintLayout;
    private ConstraintSet constraintSet;
    private RecyclerView rvGroup;
    public static final String GROUP_ID = "de.cbc.checkit.MESSAGE";
    private GroupContainer groupContainer;
    private List<UserGroup> userGroups;
    private GroupViewAdapter groupViewAdapter;

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

        rvGroup = (RecyclerView) layout.findViewById(R.id.rvGroup);

        // buttons
        FloatingActionButton btnFabAddGroup = (FloatingActionButton) layout.findViewById(R.id.fabAddGroup);
        btnFabAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddGroup_onClick();
            }
        });

        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvGroup.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvGroup.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String username = getArguments().getString(MainActivity.LOGIN_STATE);

        if (!TextUtils.isEmpty(username)) {
            try {
                groupContainer = new GroupFacade().getContainer();

                userGroups = (List<UserGroup>)groupContainer.getUserGroupCollection().getByUsername(username);

                // specify an adapter (see also next example)
                groupViewAdapter = new GroupViewAdapter(userGroups);
                rvGroup.setAdapter(groupViewAdapter);

                groupViewAdapter.setOnClickListener(new GroupViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(UserGroup item) {
                        btnGroup_onClick(item.getGroup().getGroupId());
                    }
                });

                //textViewHeadline.setText(userGroups.get(0).getGroup().getGroupName());
                //textViewSubline.setText(userGroups.get(0).getUser().getUsername());
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

    public void btnGroup_onClick(int position)
    {
        Bundle bundle = new Bundle();
        bundle.putString(GROUP_ID, Integer.toString(position));
        GroupFragment groupFragment = (GroupFragment) Fragment.instantiate(getActivity().getApplicationContext(), GroupFragment.class.getName(), bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.clMain, groupFragment);
        fragmentTransaction.commit();
    }

    public void btnAddGroup_onClick()
    {
        AddGroupDialog dialog = new AddGroupDialog(getActivity(), R.layout.dialog_group);
        dialog.showDialog();
    }
}
