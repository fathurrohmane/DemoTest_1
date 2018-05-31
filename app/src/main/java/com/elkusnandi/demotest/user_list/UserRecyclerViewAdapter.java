package com.elkusnandi.demotest.user_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elkusnandi.demotest.OnListFragmentInteraction;
import com.elkusnandi.demotest.R;
import com.elkusnandi.demotest.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {

    private final List<User> users;
    private final OnListFragmentInteraction mListener;

    public UserRecyclerViewAdapter(OnListFragmentInteraction listener) {
        users = new ArrayList<>();
        mListener = listener;
    }

    public void addUsers(List<User> users) {
        this.users.addAll(users);
        notifyDataSetChanged();
    }

    public void addUser(User user) {
        this.users.add(user);
        notifyItemInserted(users.size() - 1);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.user = users.get(position);
        holder.textViewName.setText(users.get(position).getName());
        holder.textViewEmail.setText(users.get(position).getEmail());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.user);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewName;
        public final TextView textViewEmail;
        public User user;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewName = view.findViewById(R.id.tv_name);
            textViewEmail = view.findViewById(R.id.tv_email);
        }

    }
}
