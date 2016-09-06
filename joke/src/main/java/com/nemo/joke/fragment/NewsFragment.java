package com.nemo.joke.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nemo.joke.R;
import com.nemo.joke.activity.WebViewActivity;
import com.nemo.joke.adapter.AndroidAdapter;
import com.nemo.joke.adapter.GifAdapter;
import com.nemo.joke.adapter.GirlAdapter;
import com.nemo.joke.adapter.JokenAdapter;
import com.nemo.joke.bean.Bean;
import com.nemo.joke.bean.GifBean;
import com.nemo.joke.bean.GirlBean;
import com.nemo.joke.bean.Joken;
import com.nemo.joke.http.ApiUtils;
import com.nemo.joke.http.MyRetrofit;
import com.othershe.baseadapter.BaseAdapter;
import com.othershe.baseadapter.OnItemClickListeners;
import com.othershe.baseadapter.OnLoadMoreListener;
import com.othershe.baseadapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nemo on 2016/7/24 0024.
 */
public class NewsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private String channelName;
    private String channelId;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView.LayoutManager mLayoutManager;

    private AndroidAdapter androidAdapter;
    private GifAdapter gifAdapter;
    private GirlAdapter girlAdapter;
    private JokenAdapter jokenAdapter;

    private List<GirlBean> girls;
    private List<Joken> jokens;
    private List<GifBean> gifs;
    private List<Bean.ResultsBean> others;

    private MyRetrofit<GifBean> retroGif;
    private MyRetrofit<GifBean> retroAndroid;
    private ApiUtils apiFuli;
    private ApiUtils apiJoken;

    private static String page="1";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    private View view;
    private View emptyView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {//优化View减少View的创建次数
            view = inflater.inflate(R.layout.fragment_main, container, false);
            //初始化EmptyView
            mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
            mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
            initSwipeWidget();
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(layoutManager);
            emptyView = LayoutInflater.from(getContext()).inflate(R.layout.empty_layout, (ViewGroup) mRecyclerView.getParent(), false);
            initData(false);
        }
        return view;
    }

    public void initSwipeWidget(){
        mSwipeRefreshWidget.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        mSwipeRefreshWidget.setOnRefreshListener(this);

        // 这句话是为了，第一次进入页面的时候显示加载进度条
        mSwipeRefreshWidget.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
    }

    public void initData(final boolean flag) {
        switch (channelName) {
            case "Gif":
                retroGif = new MyRetrofit<>();
                retroGif.getGifInfo(getContext(),page, new MyRetrofit.IGetInfoListener<ArrayList<GifBean>>() {
                    @Override
                    public void success(ArrayList<GifBean> o) {
                       // gifs = o;
                        if(flag){
                            gifAdapter.setLoadMoreData(o);
                        }else {
                            if(gifAdapter == null)
                             gifAdapter = new GifAdapter(getContext(),o,true);
                            else {
                                gifAdapter.setNewData(o);
                            }
                            initmRecyclerView(gifAdapter,emptyView);
                        }
                        mRecyclerView.setAdapter(gifAdapter);
                    }
                    @Override
                    public void error(String s) {
                        System.out.println(s);
                    }
                });
                break;
            case "福利":
                apiFuli = new ApiUtils();
                apiFuli.getGirlInfo("20", new MyRetrofit.IGetInfoListener<ArrayList<GirlBean>>() {
                    @Override
                    public void success(ArrayList<GirlBean> o) {
                       // girls = o;
                       // initAdapter(3);
                        if(flag)
                            girlAdapter.setLoadMoreData(o);
                        else {
                            if(girlAdapter == null)
                             girlAdapter = new GirlAdapter(getContext(), o, true);
                            else{
                                girlAdapter.setNewData(o);
                            }
                            initmRecyclerView(girlAdapter,emptyView);
                        }
                        girlAdapter.setOnItemClickListener(new OnItemClickListeners<GirlBean>() {
                            @Override
                            public void onItemClick(ViewHolder viewHolder, GirlBean data, int position) {
                                Intent intent = new Intent(getContext(), WebViewActivity.class);
                                intent.putExtra("url",data.getUrl());
                                intent.putExtra("title",data.getTitle());
                                intent.putExtra("img",data.getPicUrl());
                                startActivity(intent);
                            }
                        });
                        mRecyclerView.setAdapter(girlAdapter);
                    }
                    @Override
                    public void error(String s) {
                        System.out.println(s);
                    }
                });
                break;
            case "笑话":
                apiJoken = new ApiUtils();
                apiJoken.getJokeInfo("20", new MyRetrofit.IGetInfoListener<ArrayList<Joken>>() {
                    @Override
                    public void success(ArrayList<Joken> o) {
                        // girls = o;
                        // initAdapter(3);
                        if(flag)
                            jokenAdapter.setLoadMoreData(o);
                        else {
                            if(jokenAdapter == null)
                              jokenAdapter = new JokenAdapter(getContext(), o, true);
                            else{
                                jokenAdapter.setNewData(o);
                            }
                            initmRecyclerView(jokenAdapter,emptyView);
                        }
                        mRecyclerView.setAdapter(jokenAdapter);
                    }
                    @Override
                    public void error(String s) {
                        System.out.println(s);
                    }
                });
                break;
            default:
                retroAndroid = new MyRetrofit<>();
                retroAndroid.getGankInfo(channelName,page, new MyRetrofit.IGetInfoListener<Bean>() {
                    @Override
                    public void success(Bean o) {
                        // gifs = o;
                        if(flag)
                            androidAdapter.setLoadMoreData(o.getResults());
                        else {
                            if(androidAdapter == null)
                                androidAdapter = new AndroidAdapter(getContext(), o.getResults(), true);
                            else{
                                androidAdapter.setNewData(o.getResults());
                            }
                            initmRecyclerView(androidAdapter,emptyView);
                        }
                        androidAdapter.setOnItemClickListener(new OnItemClickListeners<Bean.ResultsBean>() {
                            @Override
                            public void onItemClick(ViewHolder viewHolder, Bean.ResultsBean data, int position) {
                                Intent intent = new Intent(getContext(), WebViewActivity.class);
                                intent.putExtra("url",data.getUrl());
                                intent.putExtra("title",data.getDesc());
                                startActivity(intent);
                            }
                        });
                        mRecyclerView.setAdapter(androidAdapter);
                    }
                    @Override
                    public void error(String s) {
                        System.out.println(s);
                    }
                });
                break;
        }
    }

    public void initmRecyclerView(BaseAdapter adapter,View emptyView) {
        adapter.setEmptyView(emptyView);
        //初始化 开始加载更多的loading View
        adapter.setLoadingView(R.layout.load_loading_layout);

        //设置加载更多触发的事件监听
        adapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                loadMore();
            }
        });
        adapter.notifyDataSetChanged();
        mSwipeRefreshWidget.setRefreshing(false);
    }

    private void loadMore() {
        page = String.valueOf(Integer.parseInt(page) + 1);
        initData(true);
    }

    @Override
    public void setArguments(Bundle bundle) {//接收传入的数据
        switch (bundle.getString("name")) {
            case "Android":
                channelName = "Android";
                break;
            case "笑话":
                channelName = "笑话";
                break;
            case "Gif":
                channelName = "Gif";
                break;
            case "图片":
                channelName = "福利";
                break;
            case "视频":
                channelName = "休息视频";
                break;
            case "其他":
                channelName = "瞎推荐";
                break;
        }
        channelId = bundle.getString("channelId");
    }

    @Override
    public void onRefresh() {
        initData(false);
    }
}