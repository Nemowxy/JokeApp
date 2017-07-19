package com.nemo.joke.utils;


import com.nemo.joke.bean.Channel;
import com.nemo.joke.bean.GifBean;
import com.nemo.joke.bean.GirlBean;
import com.nemo.joke.bean.Joken;
import com.nemo.joke.bean.TitleBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by nemo on 2016/7/25 0025.
 */
public class JSONUtils {
    public static List<Channel> getChannelList(String result){
        List<Channel> list = new ArrayList<>();

        try {
            JSONObject object = new JSONObject(result);
            JSONObject o1 = object.getJSONObject("showapi_res_body");
            JSONArray array = o1.getJSONArray("channelList");

            for (int i=0;i<array.length();i++){
                JSONObject o2 = array.getJSONObject(i);

                Channel c = new Channel();
                c.setName(o2.getString("name"));
                c.setChannelId(o2.getString("channelId"));
                list.add(c);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<TitleBean> getTitleList(String result){
        List<TitleBean> list = new ArrayList<>();

        try {
            JSONObject object = new JSONObject(result);
            JSONObject o1 = object.getJSONObject("showapi_res_body");
            JSONObject o2 = o1.getJSONObject("pagebean");
            JSONArray array = o2.getJSONArray("contentlist");
            for (int i=0;i<array.length();i++){
                JSONObject o3 = array.getJSONObject(i);
                TitleBean t = new TitleBean();
                t.setTitle(o3.getString("title"));
                t.setPubDate(o3.getString("pubDate"));
                if(o3.getJSONArray("imageurls")!=null){
                    JSONArray a2 = o3.getJSONArray("imageurls");
                    List<String> urls = new ArrayList<>();
                    for(int j=0;j<a2.length();j++){
                        JSONObject o4 = a2.getJSONObject(j);
                        urls.add(o4.getString("url"));
                    }
                    t.setImageurls(urls);
                }
                list.add(t);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }
    public static ArrayList<Joken> getJoken(String result){
        ArrayList<Joken> list = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject jsonObject1 = jsonObject.getJSONObject("showapi_res_body");
            JSONArray jsonArray = jsonObject1.getJSONArray("contentlist");
            for (int i=0;i<jsonArray.length();i++){
                JSONObject object = (JSONObject) jsonArray.get(i);
                Joken joken = new Joken();
                joken.setTitle(object.getString("title"));
                joken.setTime(object.getString("ct"));
                String str = object.getString("text").toString().trim();
                String s1=str.replaceAll("<p>","");
                String s2=s1.replaceAll("</p>","");
                String s3=s2.replaceAll("&nbsp;","");
                joken.setText(s3);
                list.add(joken);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static ArrayList<GifBean> getGif(String result){
        ArrayList<GifBean> list = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject jsonObject1 = jsonObject.getJSONObject("showapi_res_body");
            JSONArray jsonArray = jsonObject1.getJSONArray("contentlist");
            for (int i=0;i<jsonArray.length();i++){
                JSONObject object = (JSONObject) jsonArray.get(i);
                GifBean bean = new GifBean();
                bean.setTitle(object.getString("title"));
                bean.setCt(object.getString("ct"));
                bean.setImg(object.getString("img"));
                list.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static ArrayList<GirlBean> getGirls(String result){
        ArrayList<GirlBean> list = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject o1 = jsonObject.getJSONObject("showapi_res_body");

            for (int i=0;i<o1.length();i++){
                JSONObject object = o1.getJSONObject(String.valueOf(i));
                GirlBean b = new GirlBean();
                b.setTitle(object.getString("title"));
                b.setCtime("");
                b.setPicUrl(object.getString("thumb"));
                b.setUrl(object.getString("url"));
                list.add(b);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
