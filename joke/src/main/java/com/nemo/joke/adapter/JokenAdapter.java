package com.nemo.joke.adapter;

import android.content.Context;

import com.nemo.joke.R;
import com.nemo.joke.bean.Joken;
import com.othershe.baseadapter.BaseAdapter;
import com.othershe.baseadapter.ViewHolder;

import java.util.List;


//


/**
 * Created by nemo on 2016/9/5 0005.
 */

public class JokenAdapter extends BaseAdapter<Joken>{


    public JokenAdapter(Context context, List<Joken> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, Joken data) {
        holder.setText(R.id.title,data.getTitle());
        holder.setText(R.id.time,data.getTime());
        holder.setText(R.id.text,data.getText());
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.joke_item;
    }
}
