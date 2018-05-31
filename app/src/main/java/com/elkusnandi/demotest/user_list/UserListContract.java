package com.elkusnandi.demotest.user_list;

import com.elkusnandi.demotest.model.User;

import java.util.List;

public interface UserListContract {
    interface View {

        void onDataLoaded(List<User> showRespond);

        void onSingleDataLoaded(User user);

        void showProgress();

        void hideProgress();

        void showToast(String message);

    }

    interface Presenter {

        void loadUser();

        void loadUsers();

        void loadUser(int id);
    }
}

