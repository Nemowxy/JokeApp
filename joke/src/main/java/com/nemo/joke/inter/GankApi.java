package com.nemo.joke.inter;

import com.nemo.joke.bean.Bean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nemo on 2016/8/1 0001.
 */

public interface GankApi{

    @GET("api/data/{search}/20/{page}")
    Call<Bean> getInfo(@Path("search") String search,@Path("page") String page);
}
