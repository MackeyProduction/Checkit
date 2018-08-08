package de.cbc.azubiproject.models;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.asynctasks.AddUserGroupTask;
import de.cbc.azubiproject.checkit.R;
import de.cbc.azubiproject.checkit.UserTagAdapter;
import de.cbc.azubiproject.containers.RepositoryContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.interfaces.AbstractCustomDialog;

public class AddGroupDialog extends AbstractCustomDialog {
    private List<User> userList;
    private RecyclerView rvUserTag;
    private UserTagAdapter userTagAdapter;
    private TextView editTextSearchUser;
    private Button btnSearchUser;
    private EditText editTextGroupName;
    private String username;

    public AddGroupDialog(Activity activity, int resourceId) {
        super(activity, resourceId);
    }

    public AddGroupDialog(Activity activity, int resourceId, String username)
    {
        super(activity, resourceId);
        this.username = username;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void dialog_onSuccess(Dialog dialog) {
        try {
            HttpResponse httpResponse = null;

            if (!userList.isEmpty() && !TextUtils.isEmpty(editTextGroupName.getText().toString())) {
                httpResponse = new AddUserGroupTask().execute(this.username, editTextGroupName.getText().toString(), "1").get();
                for (User user : userList) {
                    httpResponse = new AddUserGroupTask().execute(user.getUsername(), editTextGroupName.getText().toString(), "0").get();
                }

                Toast.makeText(activity.getApplicationContext(), httpResponse.getStatusMessage(), Toast.LENGTH_LONG).show();
                dialog.dismiss();
            } else {
                Toast.makeText(activity.getApplicationContext(), "Es sind nicht alle Textfelder ausgefüllt.", Toast.LENGTH_LONG).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void dialog_onCancel(Dialog dialog) {
        dialog.dismiss();
    }

    @Override
    protected void onCreate(Dialog dialog) {
        userList = new ArrayList<>();
        btnSearchUser = (Button) dialog.findViewById(R.id.btnSearchUser);
        editTextGroupName = (EditText) dialog.findViewById(R.id.editTextGroupName);
        rvUserTag = (RecyclerView) dialog.findViewById(R.id.rvUserTag);

        rvUserTag.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        rvUserTag.setLayoutManager(mLayoutManager);

        btnSearchUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSearch_onClick(dialog);
            }
        });
    }

    public void btnSearch_onClick(Dialog dialog) {
        try {
            editTextSearchUser = dialog.findViewById(R.id.editTextSearchUser);

            RepositoryContainer repositoryContainer = new GroupFacade().getRepositories();
            User user = repositoryContainer.getUserGroupCollection().getUserRepository().getByUsername(editTextSearchUser.getText().toString());

            if (user != null) {
                addUser(dialog, user);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            Toast.makeText(activity.getApplicationContext(), "Benutzer nicht gefunden.", Toast.LENGTH_LONG).show();
        }
    }

    public void addUser(Dialog dialog, User user) {
        // add user
        if (!userList.contains(user)) {
            userList.add(user);
        }

        // set adapter
        userTagAdapter = new UserTagAdapter(userList);
        rvUserTag.setAdapter(userTagAdapter);
    }
}
