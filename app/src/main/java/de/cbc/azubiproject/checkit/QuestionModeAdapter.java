package de.cbc.azubiproject.checkit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;

public class QuestionModeAdapter extends RecyclerView.Adapter<QuestionModeAdapter.ViewHolder> {
    private List<QuestionAnswer> mDataset;
    private QuestionModeAdapter.OnItemClickListener clickListener;
    public interface OnItemClickListener {
        void onItemClick(QuestionAnswer item);
    }

    public void setOnClickListener(QuestionModeAdapter.OnItemClickListener listener) {
        this.clickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class ViewHolderQuestion extends RecyclerView.ViewHolder {
        public TextView textViewQuestionModeQuestion;
        public ViewHolderQuestion(View itemView) {
            super(itemView);
            textViewQuestionModeQuestion = (TextView) itemView.findViewById(R.id.textViewQuestionModeQuestion);
        }
    }

    public static class ViewHolderAnswers extends RecyclerView.ViewHolder {
        public Button btnQuestionModeAnswer, btnQuestionModeAnswer2, btnQuestionModeAnswer3, btnQuestionModeAnswer4;
        public ViewHolderAnswers(View itemView) {
            super(itemView);
            btnQuestionModeAnswer = (Button) itemView.findViewById(R.id.btnQuestionModeAnswer);
            btnQuestionModeAnswer2 = (Button) itemView.findViewById(R.id.btnQuestionModeAnswer2);
            btnQuestionModeAnswer3 = (Button) itemView.findViewById(R.id.btnQuestionModeAnswer3);
            btnQuestionModeAnswer4 = (Button) itemView.findViewById(R.id.btnQuestionModeAnswer4);
        }
    }

    public QuestionModeAdapter(List<QuestionAnswer> myDataset) {
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
        /*holder.textViewQuestionModeQuestion.setText(mDataset.get(position).getQuestion().getQuestion());
        holder.btnQuestionModeAnswer.setText(mDataset.get(position).getAnswer().getAnswer());
        holder.btnQuestionModeAnswer2.setText(mDataset.get(position+1).getAnswer().getAnswer());
        holder.btnQuestionModeAnswer3.setText(mDataset.get(position+2).getAnswer().getAnswer());
        holder.btnQuestionModeAnswer4.setText(mDataset.get(position+3).getAnswer().getAnswer());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickListener != null) {
                    clickListener.onItemClick(mDataset.get(position));
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
