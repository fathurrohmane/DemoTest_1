package com.elkusnandi.demotest.user_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.elkusnandi.demotest.DetailActivity;
import com.elkusnandi.demotest.OnListFragmentInteraction;
import com.elkusnandi.demotest.R;
import com.elkusnandi.demotest.model.User;

import java.util.List;

public class UserFragment extends Fragment implements UserListContract.View,
        OnListFragmentInteraction {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteraction listener;
    private UserRecyclerViewAdapter adapter;
    private UserListPresenter presenter;

    public UserFragment() {
    }

    public static UserFragment newInstance(int columnCount) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new UserRecyclerViewAdapter(this);
            recyclerView.setAdapter(adapter);
        }

        presenter = new UserListPresenter();
        presenter.onAttach(this);
        presenter.loadUser();
        //presenter.loadUser(1);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
        presenter.onDetach();
    }

    @Override
    public void onDataLoaded(List<User> showRespond) {
        adapter.addUsers(showRespond);
    }

    @Override
    public void onSingleDataLoaded(User user) {
        adapter.addUser(user);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListFragmentInteraction(User item) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_NAME, item.getUsername());
        intent.putExtra(DetailActivity.EXTRA_ADDRESS, item.getAddress().toString());
        intent.putExtra(DetailActivity.EXTRA_EMAIL, item.getEmail());
        intent.putExtra(DetailActivity.EXTRA_PHONE, item.getPhone());
        intent.putExtra(DetailActivity.EXTRA_WEBSITE, item.getWebsite());
        startActivity(intent);
    }
}
