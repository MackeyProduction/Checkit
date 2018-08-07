package de.cbc.azubiproject.checkit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.User;

public class UserTagAdapter extends RecyclerView.Adapter<UserTagAdapter.ViewHolder> {
    private List<User> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewUserTag;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewUserTag = (TextView) itemView.findViewById(R.id.textViewUserTag);
        }
    }

    public UserTagAdapter(List<User> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public UserTagAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_tag, parent, false);
        return new UserTagAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewUserTag.setText(mDataset.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
