package com.nemo.joke.http;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
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

    //apistore
    public static final String URL_API_BASE="http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
    public static final String URL_JOKE_INFO="http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
    public static final String URL_PHOTO_INFO="http://apis.baidu.com/txapi/mvtp/meinv";

    //gank网
    public static final String URL_GANK_BASE="http://gank.io/";
    public static final String URL_ANDROID_INFO="http://gank.io/api/search/query/listview/category/Android";
    public static final String URL_GRIL_INFO="http://gank.io/api/search/query/listview/category/福利";
    public static final String URL_GIF_INFO="http://gank.io/api/search/query/listview/category/福利";
    public static final String URL_VIDEO_INFO="http://gank.io/api/search/query/listview/category/休息视频";
    public static final String URL_OTHER_INFO="http://gank.io/api/day/2015/08/06";

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

    public void getApiStoreInfo(String page,final IGetInfoListener listener){
        Parameters para = new Parameters();
        para.put("page", page);
        ApiStoreSDK.execute(URL_API_BASE,ApiStoreSDK.GET,para,new ApiCallBack(){
            @Override
            public void onComplete() {
                System.out.println("complete");
            }

            @Override
            public void onError(int i, String s, Exception e) {
                listener.error(s);
            }

            @Override
            public void onSuccess(int i, String s) {
                listener.success(JSONUtils.getJoken(s));
            }
        });
    }


    public interface IGetInfoListener<T>{
        public void success(T t);
        public void error(String s);
    }
}
