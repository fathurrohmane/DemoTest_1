package com.elkusnandi.demotest.data;

import com.elkusnandi.demotest.model.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private Retrofit retrofit;

    public Repository() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    public Single<List<User>> getUsers() {
        return getApiService().getAllUser();
    }

    public Single<User> getUser(int id) {
        return getApiService().getUser(id);
    }

    public Observable<User> getUser() {
        return getApiService().getAllUsers();
    }

    private Api getApiService() {
        return retrofit.create(Api.class);
    }


}
