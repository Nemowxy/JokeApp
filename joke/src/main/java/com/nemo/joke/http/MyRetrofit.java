package com.nemo.joke.http;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nemo.joke.bean.Bean;
import com.nemo.joke.inter.GankApi;
import com.nemo.joke.utils.JSONUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by nemo on 2016/8/1 0001.
 */

public class  MyRetrofit<T>{


    //gank网
    public static final String URL_GANK_BASE="http://gank.io/";

    public static final String SCREET="8ac5e4c4bc9c4721a13aa3bde245679e";
    public static final String APP_ID="22759";
    public static final String URL_GIF="http://route.showapi.com/";
    private String mUrl = "";

    public MyRetrofit(){

    }

    public void getGankInfo(String searchinfo,String page,final IGetInfoListener listener){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_GANK_BASE)
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
        GankApi gankApi = retrofit.create(GankApi.class);
        Call<Bean> call = gankApi.getInfo(searchinfo,page);
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, retrofit2.Response<Bean> response) {
                listener.success(response.body());
            }
            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                listener.error(t.getMessage());
            }
        });
    }
    public void getGifInfo(Context context,String page, final IGetInfoListener listener){
        String url =URL_GIF+"341-3?maxResult=20"+"&page="+page+"&showapi_appid="+APP_ID+"&showapi_sign="+SCREET;
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.success(JSONUtils.getGif(s));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.error(volleyError.getMessage());
            }
        });
        queue.add(request);
    }


    public interface IGetInfoListener<T>{
        public void success(T t);
        public void error(String s);
    }
}
