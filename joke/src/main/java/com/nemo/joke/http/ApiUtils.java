package com.nemo.joke.http;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.nemo.joke.utils.JSONUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nemo on 2016/8/2 0002.
 */

public class ApiUtils {
    public static final String URL_API_BASE="http://route.showapi.com/341-1";
    public static final String URL_GIRL_BASE="http://route.showapi.com/197-1";




    public void getJokeInfo(Context context,final String page, final MyRetrofit.IGetInfoListener listener){
        String url =URL_API_BASE+"?showapi_appid=22759&showapi_sign=8ac5e4c4bc9c4721a13aa3bde245679e&maxResult=20&page="+page;
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(com.android.volley.Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.success(JSONUtils.getJoken(s));
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.error(volleyError.getMessage());
            }
        });
        queue.add(request);
    }

    public void getGirlInfo(Context context,final String num, final MyRetrofit.IGetInfoListener listener){
        String url =URL_GIRL_BASE+"?showapi_appid=22759&showapi_sign=8ac5e4c4bc9c4721a13aa3bde245679e&page=1&ran=1&num="+num;
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(com.android.volley.Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.success(JSONUtils.getGirls(s));
            }
        }, new com.android.volley.Response.ErrorListener() {
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
