package com.morligy.pulltorefreshandload.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.morligy.pulltorefreshandload.R;

import java.util.List;

/**
 * Created by Administrator on 2017/4/28.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private List<String> list;
    private Context context;

    public MyRecycleViewAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder) holder).tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tv ;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }

    }
}
