package com.morligy.pulltorefreshandload.view;

import android.content.Context;
import android.util.AttributeSet;

import com.jsonmo.pulltofreshandload.LoadingLayout;
import com.jsonmo.pulltofreshandload.PullToRefreshRecyclerView;


/**
 * Created by Administrator on 2017/5/22.
 */

public class MPullToRefreshRecyclerView extends PullToRefreshRecyclerView {
    public MPullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public MPullToRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MPullToRefreshRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    protected LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attrs) {
        return new MHeaderLoadingLayout(context);
    }

}
