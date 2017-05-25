package com.morligy.pulltorefreshandload;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jsonmo.pulltofreshandload.PullToRefreshRecyclerView;
import com.morligy.pulltorefreshandload.adapter.MyRecycleViewAdapter;
import com.morligy.pulltorefreshandload.view.MPullToRefreshRecyclerView;
import com.myz.mrecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshRecyclerView rv;
    private CommonRecycleViewAdapter<String> adapter;
    private MyRecycleViewAdapter myRecycleViewAdapter;
    private List<String> list;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        rv = (MPullToRefreshRecyclerView) findViewById(R.id.rv);
        rv.setPullRefreshEnabled(true);
        rv.setPullLoadEnabled(true);
       /* rv.addHeaderLoadingLayout(new HeaderLoadingLayout(MainActivity.this));
        rv.addFooterLoadingLayout(new MFooterLoadingLayout(MainActivity.this));*/
       /* adapter =new CommonRecycleViewAdapter<String>(MainActivity.this,R.layout.item) {
            @Override
            public void convert(ViewHolderHelper helper, String text) {
                helper.setText(R.id.tv,"text");
            }
        };*/
        for (int i = 0; i < 50; i++) {
            list.add("text" + (i + 1));
        }
       myRecycleViewAdapter = new MyRecycleViewAdapter(list, MainActivity.this);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = rv.getRefreshableView();
        //  rv.setAdpter(myRecycleViewAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(myRecycleViewAdapter);
       /* MyListViewAdapter myListViewAdapter = new MyListViewAdapter(list, MainActivity.this);
        lv.setAdapter(myListViewAdapter);*/
    }
}
