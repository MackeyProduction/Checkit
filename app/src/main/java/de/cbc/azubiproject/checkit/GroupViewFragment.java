package de.cbc.azubiproject.checkit;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.interfaces.DialogOnClickListener;
import de.cbc.azubiproject.models.AddGroupDialog;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.UserGroupRepository;


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
    public static final String STRING_BUNDLE = "de.cbc.checkit.MESSAGE";
    private GroupContainer groupContainer;
    private List<UserGroup> userGroups, userGroupCreated;
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
        ImageView btnFabAddGroup = (ImageView) layout.findViewById(R.id.ivAddGroup);
        btnFabAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    btnAddGroup_onClick();
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

        username = getArguments().getString(MainActivity.LOGIN_STATE);

        if (username.equals("")) {
            username = getArguments().getString(RegisterFragment.LOGIN_STATE);
        }

        if (!TextUtils.isEmpty(username)) {
            try {
                groupContainer = new GroupFacade().getContainer();

                userGroups = (List<UserGroup>)groupContainer.getUserGroupCollection().getByUsername(username);

                if (userGroups != null) {
                    // specify an adapter (see also next example)
                    groupViewAdapter = new GroupViewAdapter(userGroups, groupContainer.getUserGroupCollection());
                    rvGroup.setAdapter(groupViewAdapter);

                    groupViewAdapter.setOnClickListener(new GroupViewAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(UserGroup item) throws Exception {
                            btnGroup_onClick(item.getGroup().getGroupId());
                        }
                    });
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                Toast.makeText(getActivity().getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void btnGroup_onClick(int position) throws Exception
    {
        ArrayList<String> putString = new ArrayList<>();
        putString.add(Integer.toString(position));
        putString.add(username);

        Bundle bundle = new Bundle();
        bundle.putStringArrayList(STRING_BUNDLE, putString);

        GroupFragment groupFragment = (GroupFragment) Fragment.instantiate(getActivity().getApplicationContext(), GroupFragment.class.getName(), bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.clMain, groupFragment);
        fragmentTransaction.commit();
    }

    public void btnAddGroup_onClick() throws Exception
    {
        AddGroupDialog dialog = new AddGroupDialog(getActivity(), R.layout.dialog_group, username);
        dialog.setOnClickListener(new DialogOnClickListener() {
            @Override
            public void onOk() {
                try {
                    groupContainer = new GroupFacade().getContainer(true);
                    userGroups.clear();
                    userGroups.addAll((List<UserGroup>)groupContainer.getUserGroupCollection().getByUsername(username));
                    groupViewAdapter.notifyDataSetChanged();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.showDialog();
    }
}
