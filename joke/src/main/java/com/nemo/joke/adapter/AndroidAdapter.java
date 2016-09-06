package com.nemo.joke.adapter;

import android.content.Context;
import android.view.View;

import com.nemo.joke.R;
import com.nemo.joke.bean.Bean;
import com.othershe.baseadapter.BaseAdapter;
import com.othershe.baseadapter.ViewHolder;

import java.util.List;

/**
 * Created by nemo on 2016/9/5 0005.
 */

public class AndroidAdapter extends BaseAdapter<Bean.ResultsBean>{

    private Context context;

    public AndroidAdapter(Context context, List<Bean.ResultsBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, Bean.ResultsBean data) {
        holder.setText(R.id.title,data.getDesc());
        holder.setText(R.id.date,data.getCreatedAt());
        //holder.setText(R.id.titleImg,data.getText());
        holder.getView(R.id.titleImg).setVisibility(View.GONE);

    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.list_item;
    }

}
