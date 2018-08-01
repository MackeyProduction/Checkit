package de.cbc.azubiproject.models;

import android.app.Activity;
import android.app.Dialog;

import de.cbc.azubiproject.interfaces.AbstractCustomDialog;

public class AddQuestionDialog extends AbstractCustomDialog {
    public AddQuestionDialog(Activity activity, int resourceId) {
        super(activity, resourceId);
    }

    @Override
    protected void dialog_onSuccess(Dialog dialog) {
        dialog.dismiss();
    }

    @Override
    protected void dialog_onCancel(Dialog dialog) {
        dialog.dismiss();
    }
}
