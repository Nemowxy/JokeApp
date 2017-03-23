package com.nemo.joke.http;

import android.util.Log;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.nemo.joke.utils.JSONUtils;

/**
 * Created by nemo on 2016/8/2 0002.
 */

public class ApiUtils {
        public static final String URL_API_BASE="http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
    public static final String URL_GIRL_BASE="http://apis.baidu.com/txapi/mvtp/meinv";




    public void getJokeInfo(String page,final MyRetrofit.IGetInfoListener listener){
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
                Log.e("onSuccess: ",s );
                listener.success(JSONUtils.getJoken(s));
            }
        });
    }

    public void getGirlInfo(String num,final MyRetrofit.IGetInfoListener listener){
        Parameters para = new Parameters();
        para.put("num", num);
        ApiStoreSDK.execute(URL_GIRL_BASE,ApiStoreSDK.GET,para,new ApiCallBack(){
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
                listener.success(JSONUtils.getGirls(s));
            }
        });
    }


    public interface IGetInfoListener<T>{
        public void success(T t);
        public void error(String s);
    }
}
