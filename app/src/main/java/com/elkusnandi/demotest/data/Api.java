package com.elkusnandi.demotest.data;

import com.elkusnandi.demotest.model.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("user")
    Single<List<User>> getAllUser();

    @GET("user")
    Observable<User> getAllUsers();

    @GET("user/{id}")
    Single<User> getUser(@Path("id") int id);
}
