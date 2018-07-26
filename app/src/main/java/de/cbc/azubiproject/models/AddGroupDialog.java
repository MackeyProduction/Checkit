package de.cbc.azubiproject.models;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;

import de.cbc.azubiproject.interfaces.AbstractCustomDialog;

public class AddGroupDialog extends AbstractCustomDialog {
    public AddGroupDialog(Activity activity, int resourceId) {
        super(activity, resourceId);
    }

    @Override
    protected void dialog_onSuccess(Dialog dialog) {

    }

    @Override
    protected void dialog_onCancel(Dialog dialog) {
        dialog.dismiss();
    }

    public void btnSearch_onClick(View view)
    {

    }
}
