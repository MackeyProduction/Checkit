package de.cbc.azubiproject.checkit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.UserGroupRepository;

public class GroupViewAdapter extends RecyclerView.Adapter<GroupViewAdapter.ViewHolder> {
    private List<UserGroup> mDataset;
    private UserGroupRepository userGroupCreated;
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

    public GroupViewAdapter(List<UserGroup> myDataset, UserGroupRepository userGroup) {
        mDataset = myDataset;
        userGroupCreated = userGroup;
    }

    @Override
    public GroupViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            holder.textViewGroupHeadline.setText(mDataset.get(position).getGroup().getGroupName());
            holder.textViewGroupSubline.setText("Erstellt von: " + ((UserGroup)userGroupCreated.getByCreatedStatus(mDataset.get(position).getGroup().getGroupId())).getUser().getUsername());

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
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}