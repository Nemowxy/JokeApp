package com.nemo.joke.inter;

import com.nemo.joke.bean.AndroidBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nemo on 2016/8/1 0001.
 */

public interface GankApi {

    @GET("/{search}/20/1")
    Call<AndroidBean> getAndroid(@Path("search") String search);
}
