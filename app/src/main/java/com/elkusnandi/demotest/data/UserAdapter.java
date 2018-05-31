package com.elkusnandi.demotest.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elkusnandi.demotest.R;
import com.elkusnandi.demotest.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int USER_TYPE = 0;

    private List<User> users;

    public UserAdapter() {
        users = new ArrayList<>();
    }

    public void addData(List<User> users) {
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case USER_TYPE:
                View view = inflater.inflate(R.layout.item_user, parent, false);
                return new UserViewHolder(view);
            default:
                throw new IllegalArgumentException("Wrong view type");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserViewHolder userViewHolder = (UserViewHolder) holder;

        switch (getItemViewType(position)) {
            default:
                userViewHolder.textViewName.setText(users.get(position).getName());
                userViewHolder.textViewEmail.setText(users.get(position).getEmail());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return USER_TYPE;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;
        TextView textViewEmail;

        public UserViewHolder(View itemView) {
            super(itemView);

            itemView.findViewById(R.id.tv_name);
            itemView.findViewById(R.id.tv_email);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
