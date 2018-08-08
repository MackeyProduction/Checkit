package de.cbc.azubiproject.checkit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import de.cbc.azubiproject.models.Answer;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.QuestionAnswerHelper;
import de.cbc.azubiproject.models.UserGroup;

public class QuestionModeAdapter extends RecyclerView.Adapter<QuestionModeAdapter.ViewHolder> {
    private List<QuestionAnswerHelper> mDataset;
    private QuestionModeAdapter.OnItemClickListener clickListener;
    public interface OnItemClickListener {
        void onItemClick(Button btn, int correct);
    }

    public void setOnClickListener(QuestionModeAdapter.OnItemClickListener listener) {
        this.clickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewQuestionModeQuestion;
        public Button btnQuestionModeAnswer, btnQuestionModeAnswer2, btnQuestionModeAnswer3, btnQuestionModeAnswer4;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewQuestionModeQuestion = (TextView) itemView.findViewById(R.id.textViewQuestionModeQuestion);
            btnQuestionModeAnswer = (Button) itemView.findViewById(R.id.btnQuestionModeAnswer);
            btnQuestionModeAnswer2 = (Button) itemView.findViewById(R.id.btnQuestionModeAnswer2);
            btnQuestionModeAnswer3 = (Button) itemView.findViewById(R.id.btnQuestionModeAnswer3);
            btnQuestionModeAnswer4 = (Button) itemView.findViewById(R.id.btnQuestionModeAnswer4);
        }
    }

    public QuestionModeAdapter(List<QuestionAnswerHelper> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public QuestionModeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_question_mode_item, parent, false);
        return new QuestionModeAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewQuestionModeQuestion.setText(mDataset.get(position).getQuestion().getQuestion());

        try {
            // get answers
            for (int i = 0; i < mDataset.get(position).getAnswers().length; i = i+4) {
                holder.btnQuestionModeAnswer.setText(mDataset.get(position).getAnswers()[i].getAnswer());
                holder.btnQuestionModeAnswer2.setText(mDataset.get(position).getAnswers()[i+1].getAnswer());
                holder.btnQuestionModeAnswer3.setText(mDataset.get(position).getAnswers()[i+2].getAnswer());
                holder.btnQuestionModeAnswer4.setText(mDataset.get(position).getAnswers()[i+3].getAnswer());
            }

            // set clickListener
            for (int i = 0; i < mDataset.get(position).getAnswers().length; i++) {
                int curPos = i % 4;
                Button btn = getButton(curPos, holder);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(clickListener != null) {
                            clickListener.onItemClick(btn, mDataset.get(position).getCorrect()[curPos]);
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public Button getButton(int position, ViewHolder viewHolder)
    {
        Button btn = null;
        switch (position) {
            case 0:
                btn = viewHolder.btnQuestionModeAnswer;
                break;
            case 1:
                btn = viewHolder.btnQuestionModeAnswer2;
                break;
            case 2:
                btn = viewHolder.btnQuestionModeAnswer3;
                break;
            case 3:
                btn = viewHolder.btnQuestionModeAnswer4;
                break;
        }

        return btn;
    }
}
