package com.nemo.joke.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nemo.joke.R;
import com.nemo.joke.bean.GifBean;
import com.othershe.baseadapter.BaseAdapter;
import com.othershe.baseadapter.ViewHolder;

import java.util.List;

/**
 * Created by nemo on 2016/9/5 0005.
 */

public class GifAdapter extends BaseAdapter<GifBean>{

    private Context context;

    public GifAdapter(Context context, List<GifBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, GifBean data) {
        holder.setText(R.id.title,data.getTitle());
        holder.setText(R.id.time,data.getCt());
        if(data.getImg()!=null){
            ImageView iv = holder.getView(R.id.gif_view);
            Glide.with(context).load(data.getImg()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
        }
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.gif_item;
    }
}
