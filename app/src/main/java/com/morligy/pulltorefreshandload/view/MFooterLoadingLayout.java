package com.morligy.pulltorefreshandload.view;

/**
 * Created by Administrator on 2017/5/19.
 */

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jsonmo.pulltofreshandload.LoadingLayout;
import com.morligy.pulltorefreshandload.R;


/**
 * 这个类封装了下拉刷新的布局
 *
 * @author Li Hong
 * @since 2013-7-30
 */
public class MFooterLoadingLayout extends LoadingLayout {
    /** 进度条 */
    private ProgressBar mProgressBar;
    /** 显示的文本 */
    private TextView mHintView;
    private ImageView frame;
    private AnimationDrawable frameAnimation;

    /**
     * 构造方法
     *
     * @param context
     *            context
     */
    public MFooterLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    /**
     * 构造方法
     *
     * @param context
     *            context
     * @param attrs
     *            attrs
     */
    public MFooterLoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 初始化
     *
     * @param context
     *            context
     */
    private void init(Context context) {
        frame = (ImageView) findViewById(R.id.frame);
        frameAnimation = (AnimationDrawable) frame.getDrawable();
        // mProgressBar = (ProgressBar)
        // findViewById(R.id.pull_to_load_footer_progressbar);
        mHintView = (TextView) findViewById(R.id.pull_to_load_footer_hint_textview);

        setState(State.RESET);
    }

    @Override
    protected View createLoadingView(Context context, AttributeSet attrs) {
        View container = LayoutInflater.from(context).inflate(
                R.layout.mpull_to_load_layout, null);
        return container;
    }

    @Override
    public void setLastUpdatedLabel(CharSequence label) {
    }

    @Override
    public int getContentSize() {
        View view = findViewById(R.id.pull_to_load_footer_content);
        if (null != view) {
            return view.getHeight();
        }

        return (int) (getResources().getDisplayMetrics().density * 40);
    }

    @Override
    protected void onStateChanged(State curState, State oldState) {
        // mProgressBar.setVisibility(View.GONE);
//		frameAnimation.stop();
//		frame.setVisibility(GONE);
        mHintView.setVisibility(View.INVISIBLE);

        super.onStateChanged(curState, oldState);
    }

    @Override
    protected void onReset() {
//		frameAnimation.stop();
        mHintView.setText(R.string.pull_to_refresh_header_hint_loading);
    }

    @Override
    protected void onPullToRefresh() {
        frame.setVisibility(VISIBLE);
        if (frameAnimation.isRunning()) {
            frameAnimation.stop();
        }
        mHintView.setVisibility(View.VISIBLE);
        mHintView.setText(R.string.pull_to_refresh_header_hint_normal2);
    }

    @Override
    protected void onReleaseToRefresh() {
        mHintView.setVisibility(View.VISIBLE);
        mHintView.setText(R.string.pull_to_refresh_header_hint_ready);
    }

    @Override
    protected void onRefreshing() {
        frameAnimation.start();
        // mProgressBar.setVisibility(View.VISIBLE);
        mHintView.setVisibility(View.VISIBLE);
        mHintView.setText(R.string.pull_to_refresh_header_hint_loading);
    }

    @Override
    protected void onNoMoreData() {
        mHintView.setVisibility(View.VISIBLE);
        mHintView.setText(R.string.pushmsg_center_no_more_msg);
    }
}