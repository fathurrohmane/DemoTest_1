package com.elkusnandi.demotest.user_list;

import com.elkusnandi.demotest.data.Repository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class UserListPresenter implements UserListContract.Presenter {

    private UserListContract.View view;
    private CompositeDisposable disposable;
    private Repository repository;

    public UserListPresenter() {
        disposable = new CompositeDisposable();
        repository = new Repository();
    }

    public void onAttach(UserListContract.View view) {
        this.view = view;
    }

    public void onDetach() {
        disposable.clear();
    }

    @Override
    public void loadUser() {
        view.showProgress();
        disposable.add(
                repository.getUsers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe((users, throwable) -> {
                            if (throwable == null) {
                                view.onDataLoaded(users);
                                view.hideProgress();
                            } else {
                                view.showToast(throwable.getMessage());
                            }
                        })
        );

    }

    @Override
    public void loadUsers() {
        disposable.add(
                repository.getUser()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                // on next
                                user -> view.onSingleDataLoaded(user),
                                // on error
                                throwable ->  view.showToast(throwable.getMessage()),
                                // on complete
                                () -> view.showProgress()
                        )
        );
    }

    @Override
    public void loadUser(int id) {
        disposable.add(
                repository.getUser(id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                (user, throwable) -> {
                                    if (throwable == null) {
                                        view.onSingleDataLoaded(user);
                                    } else {
                                        view.showToast(throwable.getMessage());
                                    }
                                }
                        )
        );
    }
}
