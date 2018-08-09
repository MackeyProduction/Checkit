package de.cbc.azubiproject.checkit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.cbc.azubiproject.models.QuestionAnswer;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {
    private List<QuestionAnswer> questionAnswerList;
    private GroupAdapter.OnItemClickListener clickListener;
    public interface OnItemClickListener {
        void onItemClick(QuestionAnswer item, TextView textViewQuestion) throws Exception;
    }

    public void setOnClickListener(GroupAdapter.OnItemClickListener listener) {
        this.clickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewQuestion;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewQuestion = (TextView) itemView.findViewById(R.id.textViewQuestion);
        }
    }

    public GroupAdapter(List<QuestionAnswer> questionAnswers)
    {
        this.questionAnswerList = questionAnswers;
    }

    @Override
    public GroupAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder((LayoutInflater.from(parent.getContext()).inflate(R.layout.group_question_item, parent, false)));
    }

    @Override
    public void onBindViewHolder(GroupAdapter.ViewHolder holder, int position) {
        holder.textViewQuestion.setText(questionAnswerList.get(position).getQuestion().getQuestion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    try {
                        clickListener.onItemClick(questionAnswerList.get(position), holder.textViewQuestion);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionAnswerList.size();
    }
}
