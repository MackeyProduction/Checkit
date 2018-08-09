package de.cbc.azubiproject.checkit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.cbc.azubiproject.models.UserGroup;

public class GroupViewAdapter extends RecyclerView.Adapter<GroupViewAdapter.ViewHolder> {
    private List<UserGroup> mDataset;
    private OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onItemClick(UserGroup item) throws Exception;
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.clickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewGroupHeadline, textViewGroupSubline;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewGroupHeadline = (TextView) itemView.findViewById(R.id.textViewGroupHeadline);
            textViewGroupSubline = (TextView) itemView.findViewById(R.id.textViewGroupSubline);
        }
    }

    public GroupViewAdapter(List<UserGroup> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public GroupViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewGroupHeadline.setText(mDataset.get(position).getGroup().getGroupName());
        holder.textViewGroupSubline.setText(mDataset.get(position).getUser().getUsername());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    try {
                        clickListener.onItemClick(mDataset.get(position));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}