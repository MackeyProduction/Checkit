package de.cbc.azubiproject.models;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.w3c.dom.Text;

import de.cbc.azubiproject.asynctasks.AddQuestionTask;
import de.cbc.azubiproject.checkit.R;
import de.cbc.azubiproject.http.HttpResponse;
import de.cbc.azubiproject.interfaces.AbstractCustomDialog;

public class AddQuestionDialog extends AbstractCustomDialog {
    private String[] dataEditText;
    private int[] dataRadioButton;
    private String username, groupName;

    public AddQuestionDialog(Activity activity, int resourceId) {
        super(activity, resourceId);
    }

    public AddQuestionDialog(Activity activity, int resourceId, String username, String groupName)
    {
        super(activity, resourceId);
        this.username = username;
        this.groupName = groupName;
    }

    @Override
    protected void dialog_onSuccess(Dialog dialog) {
        HttpResponse httpResponse;

        try {
            // edit text
            EditText editTextQuestion = (EditText) dialog.findViewById(R.id.editTextGroupName);
            EditText editTextAnswer1 = (EditText) dialog.findViewById(R.id.editTextSearchUser);
            EditText editTextAnswer2 = (EditText) dialog.findViewById(R.id.editTextAnswer2);
            EditText editTextAnswer3 = (EditText) dialog.findViewById(R.id.editTextAnswer3);
            EditText editTextAnswer4 = (EditText) dialog.findViewById(R.id.editTextAnswer4);
            EditText editTextAnswerFreeText = (EditText) dialog.findViewById(R.id.editTextAnswerFreeText);

            // radiobuttons
            int radioButtonAnswerCorrect1 = (((RadioButton) dialog.findViewById(R.id.radioButtonAnswerCorrect1)).isChecked()) ? 1 : 0;
            int radioButtonAnswerCorrect2 = (((RadioButton) dialog.findViewById(R.id.radioButtonAnswerCorrect2)).isChecked()) ? 1 : 0;
            int radioButtonAnswerCorrect3 = (((RadioButton) dialog.findViewById(R.id.radioButtonAnswerCorrect3)).isChecked()) ? 1 : 0;
            int radioButtonAnswerCorrect4 = (((RadioButton) dialog.findViewById(R.id.radioButtonAnswerCorrect4)).isChecked()) ? 1 : 0;

            if (!editTextQuestion.getText().toString().equals("") && !(editTextAnswer1.getText().toString().equals("")) && !editTextAnswer2.getText().toString().equals("") && !editTextAnswer3.getText().toString().equals("") && editTextAnswer4.getText().toString().equals("") && !editTextAnswerFreeText.getText().toString().equals("")) {
                dataEditText = new String[]{editTextAnswer1.getText().toString(), editTextAnswer2.getText().toString(), editTextAnswer3.getText().toString(), editTextAnswer4.getText().toString()};
                dataRadioButton = new int[]{radioButtonAnswerCorrect1, radioButtonAnswerCorrect2, radioButtonAnswerCorrect3, radioButtonAnswerCorrect4};

                // add multiple choice to database
                for (int i = 0; i < dataEditText.length; i++) {
                    new AddQuestionTask().execute(username, groupName, editTextQuestion.getText().toString(), dataEditText[i], "1", Integer.toString(dataRadioButton[i])).get();
                }

                // add free text answer
                httpResponse = new AddQuestionTask().execute(username, groupName, editTextQuestion.getText().toString(), editTextAnswerFreeText.getText().toString(), "2", "1").get();

                // successful
                Toast.makeText(activity.getApplicationContext(), httpResponse.getStatusMessage(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(activity.getApplicationContext(), "Bitte alle Textfelder ausfüllen.", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }

    @Override
    protected void dialog_onCancel(Dialog dialog) {
        dialog.dismiss();
    }

    @Override
    protected void onCreate(Dialog dialog) {

    }
}
