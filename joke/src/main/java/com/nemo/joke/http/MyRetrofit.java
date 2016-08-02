package com.nemo.joke.http;

import android.content.Context;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.nemo.joke.app.App;
import com.nemo.joke.bean.AndroidBean;
import com.nemo.joke.inter.GankApi;

import org.json.JSONObject;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by nemo on 2016/8/1 0001.
 */

public class MyRetrofit{

    //apistore
    public static final String URL_API_BASE="http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
    public static final String URL_JOKE_INFO="http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
    public static final String URL_PHOTO_INFO="http://apis.baidu.com/txapi/mvtp/meinv";

    //gank网
    public static final String URL_GANK_BASE="http://gank.io/api/search/query/listview/category/";
    public static final String URL_ANDROID_INFO="http://gank.io/api/search/query/listview/category/Android";
    public static final String URL_GRIL_INFO="http://gank.io/api/search/query/listview/category/福利";
    public static final String URL_GIF_INFO="http://gank.io/api/search/query/listview/category/福利";
    public static final String URL_VIDEO_INFO="http://gank.io/api/search/query/listview/category/休息视频";
    public static final String URL_OTHER_INFO="http://gank.io/api/day/2015/08/06";

    private String mUrl = "";

    public MyRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_GANK_BASE)
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
        GankApi gankApi = retrofit.create(GankApi.class);
        Call<AndroidBean> call = gankApi.getAndroid("Android");
        call.enqueue(new Callback<AndroidBean>() {
            @Override
            public void onResponse(Call<AndroidBean> call, retrofit2.Response<AndroidBean> response) {
                System.out.println(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<AndroidBean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
