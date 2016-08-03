package com.nemo.joke.inter;

import com.nemo.joke.bean.Bean;
import com.nemo.joke.bean.GifBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by nemo on 2016/8/3 0003.
 */

public interface GIFApi {

    @POST("341-3")
    Call<GifBean> getInfo(@Field("showapi_appid") String appid, @Field("showapi_sign") String sign,@Field("page") String page,@Field("maxResult") String max);
}
