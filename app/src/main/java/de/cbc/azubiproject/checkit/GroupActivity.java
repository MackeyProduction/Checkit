package de.cbc.azubiproject.checkit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.cbc.azubiproject.models.ActionBarHelper;
import de.cbc.azubiproject.models.AddQuestionDialog;

public class GroupActivity extends ActionBarHelper {
    private TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        questionTextView = (TextView) findViewById(R.id.textViewQuestion);
        Typeface ubuntu = Typeface.createFromAsset(getAssets(), "font/Ubuntu-R.ttf");
        questionTextView.setTypeface(ubuntu);
    }

    public void btnQuizMode_onClick(View view)
    {
        Intent intent = new Intent(this, QuestionModeActivity.class);
        startActivity(intent);
    }

    public void btnAddQuestion_onClick(View view)
    {
        AddQuestionDialog addQuestionDialog = new AddQuestionDialog(this, R.layout.dialog_group_question);
        addQuestionDialog.showDialog();
    }
}