package com.nemo.joke.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nemo.joke.R;
import com.nemo.joke.activity.WebViewActivity;
import com.nemo.joke.bean.Bean;
import com.nemo.joke.bean.GifBean;
import com.nemo.joke.bean.GirlBean;
import com.nemo.joke.bean.Joken;
import com.nemo.joke.http.ApiUtils;
import com.nemo.joke.http.MyRetrofit;
import com.nemo.joke.view.CommonAdapter;
import com.nemo.joke.view.ViewHolder;
import com.nemo.joke.view.XListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by nemo on 2016/7/24 0024.
 */
public class NewsFragment extends Fragment implements XListView.IXListViewListener {
    private String weburl;
    private String channelName;
    private String channelId;
    private XListView xListView;
    private CommonAdapter<Bean.ResultsBean> adapter;
    private CommonAdapter<Joken> adapter2;
    private CommonAdapter<GirlBean> adapter3;
    private CommonAdapter<GifBean> adapter4;
    private List<Bean.ResultsBean> items;
    private List<Joken> items2;
    private List<GirlBean> items3;
    private List<GifBean> items4;
    private static String page = "1";
    private MyRetrofit<Bean> retrofit;
    private MyRetrofit<GifBean> retrofit2;
    private ApiUtils apiUtils;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {//优化View减少View的创建次数
            view = inflater.inflate(R.layout.fragment_main, container, false);
            initListView();
        }
        return view;
    }

    private void initListView() {
        xListView = (XListView) view.findViewById(R.id.list);
        xListView.setPullLoadEnable(true);
        xListView.setPullLoadEnable(true);//设置是否可以上拉加载
        xListView.setPullRefreshEnable(true);//设置是否可以下拉刷新
        xListView.setXListViewListener(this);
        if (channelName.equals("笑话")) {
            apiUtils = new ApiUtils();
            apiUtils.getJokeInfo(page, new MyRetrofit.IGetInfoListener<ArrayList<Joken>>() {
                @Override
                public void success(ArrayList<Joken> o) {
                    items2 = o;
                    initAdapter(2);
                }

                @Override
                public void error(String s) {
                    System.out.println(s);
                }
            });
        } else if (channelName.equals("福利")) {
            apiUtils = new ApiUtils();
            apiUtils.getGirlInfo("20", new MyRetrofit.IGetInfoListener<ArrayList<GirlBean>>() {
                @Override
                public void success(ArrayList<GirlBean> o) {
                    items3 = o;
                    initAdapter(3);
                }

                @Override
                public void error(String s) {
                    System.out.println(s);
                }
            });
        } else if (channelName.equals("Gif")) {
            retrofit2 = new MyRetrofit<>();
            retrofit2.getGifInfo(getContext(),page, new MyRetrofit.IGetInfoListener<ArrayList<GifBean>>() {
                @Override
                public void success(ArrayList<GifBean> o) {
                    items4 = o;
                    initAdapter(4);
                }

                @Override
                public void error(String s) {
                    System.out.println(s);
                }
            });
        } else {
            retrofit = new MyRetrofit<>();
            retrofit.getGankInfo(channelName, page, new MyRetrofit.IGetInfoListener<Bean>() {
                @Override
                public void success(Bean o) {
                    items = o.getResults();
                    initAdapter(1);
                }

                @Override
                public void error(String s) {
                    System.out.println(s);
                }
            });
        }
    }

    private void initAdapter(int f) {
        if (f == 1) {
            adapter = new CommonAdapter<Bean.ResultsBean>(getContext(), items, R.layout.list_item) {
                @Override
                public void convert(ViewHolder holder, final Bean.ResultsBean t) {
                    holder.setText(R.id.title, t.getDesc());
                    holder.setText(R.id.date, t.getCreatedAt());
                    final ImageView iv = holder.getView(R.id.titleImg);
                    if (channelName.equals("福利")) {
                        iv.setVisibility(View.VISIBLE);
                        Glide.with(getContext()).load(t.getUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
                    } else {
                        iv.setVisibility(View.GONE);
                    }
                    LinearLayout ll = holder.getView(R.id.item_layout);
                    ll.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getContext(), WebViewActivity.class);
                            intent.putExtra("url", t.getUrl());
                            startActivity(intent);
                        }
                    });
                }
            };
            xListView.setAdapter(adapter);
        } else if (f == 3) {
            adapter3 = new CommonAdapter<GirlBean>(getContext(), items3, R.layout.list_item) {
                @Override
                public void convert(ViewHolder holder, final GirlBean t) {
                    holder.setText(R.id.title, t.getTitle());
                    holder.setText(R.id.date, t.getCtime());
                    final ImageView iv = holder.getView(R.id.titleImg);
                    if (channelName.equals("福利")) {
                        iv.setVisibility(View.VISIBLE);
                        Picasso.with(getContext()).load(t.getPicUrl()).resize(500, 400).centerCrop().into(iv);
                    } else {
                        iv.setVisibility(View.GONE);
                    }
                    LinearLayout ll = holder.getView(R.id.item_layout);
                    ll.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getContext(), WebViewActivity.class);
                            intent.putExtra("url", t.getUrl());
                            startActivity(intent);
                        }
                    });
                }
            };
            xListView.setAdapter(adapter3);
        } else if (f == 4) {
            adapter4 = new CommonAdapter<GifBean>(getContext(), items4, R.layout.gif_item) {
                @Override
                public void convert(ViewHolder holder, final GifBean t) {
                    holder.setText(R.id.title, t.getTitle());
                    holder.setText(R.id.time, t.getCt());
                    ImageView iv = holder.getView(R.id.gif_view);
                    Glide.with(getContext()).load(t.getImg()).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
                }
            };
            xListView.setAdapter(adapter4);
        } else {
            adapter2 = new CommonAdapter<Joken>(getContext(), items2, R.layout.joke_item) {
                @Override
                public void convert(ViewHolder holder, final Joken t) {
                    holder.setText(R.id.title, t.getTitle());
                    holder.setText(R.id.time, t.getTime());
                    holder.setText(R.id.text, t.getText());
                }
            };
            xListView.setAdapter(adapter2);
        }
    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {
        page = String.valueOf(Integer.parseInt(page) + 1);
        if (channelName.equals("笑话")) {
            retrofit.getGankInfo(channelName, page, new MyRetrofit.IGetInfoListener<Bean>() {
                @Override
                public void success(Bean o) {
                    items.addAll(o.getResults());
                    adapter.notifyDataSetChanged();
                    onLoad();
                }

                @Override
                public void error(String s) {
                    System.out.println(s);
                }
            });
        }else if (channelName.equals("Gif")) {
            retrofit2.getGifInfo(getContext(),page, new MyRetrofit.IGetInfoListener<ArrayList<GifBean>>() {
                @Override
                public void success(ArrayList<GifBean> o) {
                    items4.addAll(o);
                    adapter4.notifyDataSetChanged();
                    onLoad();
                }

                @Override
                public void error(String s) {
                    System.out.println(s);
                }
            });
        } else if (channelName.equals("福利")) {
            apiUtils.getGirlInfo("20", new MyRetrofit.IGetInfoListener<ArrayList<GirlBean>>() {
                @Override
                public void success(ArrayList<GirlBean> o) {
                    items3.addAll(o);
                    adapter3.notifyDataSetChanged();
                    onLoad();
                }

                @Override
                public void error(String s) {
                    System.out.println(s);
                }
            });
        } else {
            apiUtils.getJokeInfo(page, new MyRetrofit.IGetInfoListener<ArrayList<Joken>>() {
                @Override
                public void success(ArrayList<Joken> o) {
                    items2.addAll(o);
                    adapter2.notifyDataSetChanged();
                    onLoad();
                }

                @Override
                public void error(String s) {
                    System.out.println(s);
                }
            });
        }
    }

    private void onLoad() {
        xListView.stopRefresh();
        xListView.stopLoadMore();
        xListView.setRefreshTime("刚刚");
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
}