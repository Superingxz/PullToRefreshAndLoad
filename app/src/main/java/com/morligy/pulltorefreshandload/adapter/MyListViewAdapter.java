package com.morligy.pulltorefreshandload.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.morligy.pulltorefreshandload.R;

import java.util.List;

/**
 * Created by Administrator on 2017/4/28.
 */

public class MyListViewAdapter extends BaseAdapter {
    private List<String> list;
    private LayoutInflater inflater;
    private Context context;

    public MyListViewAdapter(List<String> list,  Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item, parent, false);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(list.get(position));
        return convertView;
    }

    class ViewHolder{
        TextView tv;
    }
}
