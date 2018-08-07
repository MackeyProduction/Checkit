package de.cbc.azubiproject.interfaces;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import de.cbc.azubiproject.checkit.R;

public abstract class AbstractCustomDialog extends AppCompatActivity {
    protected Activity activity;
    protected int resourceId;

    public AbstractCustomDialog(Activity activity, int resourceId)
    {
        this.activity = activity;
        this.resourceId = resourceId;
    }

    public void showDialog()
    {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(resourceId);

        Button btnOnSuccess = (Button) dialog.findViewById(R.id.btnDialogSuccess);
        Button btnOnCancel = (Button) dialog.findViewById(R.id.btnDialogCancel);

        btnOnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_onSuccess(dialog);
            }
        });

        btnOnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_onCancel(dialog);
            }
        });

        onCreate(dialog);
        dialog.show();
    }

    protected abstract void dialog_onSuccess(Dialog dialog);
    protected abstract void dialog_onCancel(Dialog dialog);
    protected abstract void onCreate(Dialog dialog);
}
