package com.nemo.joke.adapter;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import com.nemo.joke.R;
import com.nemo.joke.activity.WebViewActivity;
import com.nemo.joke.bean.GirlBean;
import com.othershe.baseadapter.BaseAdapter;
import com.othershe.baseadapter.OnItemClickListeners;
import com.othershe.baseadapter.ViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by nemo on 2016/9/5 0005.
 */

public class GirlAdapter extends BaseAdapter<GirlBean> implements OnItemClickListeners<GirlBean>{
    private Context context;

    public GirlAdapter(Context context, List<GirlBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, GirlBean data) {
        holder.setText(R.id.title,data.getTitle());
        holder.setText(R.id.date,data.getCtime());
        if(data.getPicUrl()!=null){
            ImageView iv = holder.getView(R.id.titleImg);
            Picasso.with(context).load(data.getPicUrl()).resize(500, 400).centerCrop().into(iv);
        }
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.list_item;
    }

    @Override
    public void onItemClick(ViewHolder viewHolder, GirlBean data, int position) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("url",data.getUrl());
        context.startActivity(intent);
    }
}
