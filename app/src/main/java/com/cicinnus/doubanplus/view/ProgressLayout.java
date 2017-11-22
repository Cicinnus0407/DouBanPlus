package com.cicinnus.doubanplus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.cicinnus.corelib.rx.SchedulersCompact;
import com.cicinnus.doubanplus.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;


/**
 * 三种状态的LinearLayout，用于切换当前的页面显示
 * ERROR,CONTENT,LOADING
 */

public class ProgressLayout extends LinearLayout {
    private static final String LOADING_TAG = "loading_tag";
    private static final String ERROR_TAG = "error_tag";


    private LayoutParams layoutParams;
    private LayoutInflater layoutInflater;
    private LinearLayout loadingView, errorView;

    private TextView btn_error;

    private List<View> contentViews = new ArrayList<>();
    private RotateAnimation rotateAnimation;

    public ProgressLayout(Context context) {
        super(context);
    }

    private enum State {
        LOADING, CONTENT, ERROR
    }

    private State currentState = State.LOADING;

    public ProgressLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ProgressLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if (child.getTag() == null || (!child.getTag().equals(LOADING_TAG)
                && !child.getTag().equals(ERROR_TAG))) {
            contentViews.add(child);
        }
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (btn_error != null) {
            btn_error.setOnClickListener(null);
        }
    }

    public void showLoading() {
        currentState = State.LOADING;
        this.showLoadingView();
        this.hideErrorView();
        this.setContentVisibility(false);
    }

    public void showContent() {
        //延迟400毫秒显示
        Observable.timer(400, TimeUnit.MILLISECONDS)
                .compose(SchedulersCompact.<Long>applyIoSchedulers())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        currentState = State.CONTENT;
                        ProgressLayout.this.setContentVisibility(true);
                        ProgressLayout.this.hideLoadingView();
                        ProgressLayout.this.hideErrorView();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }

    public void showError(OnClickListener click) {
        currentState = State.ERROR;
        this.hideLoadingView();
        this.showErrorView();
        this.btn_error.setOnClickListener(click);
        hideContentView();
    }


    public boolean isContent() {
        return currentState == State.CONTENT;
    }

    /**
     * 显示加载中布局
     */
    private void showLoadingView() {
        if (loadingView == null) {
            loadingView = (LinearLayout) layoutInflater.inflate(R.layout.layout_loading_view, null);
            loadingView.setTag(LOADING_TAG);
            layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            layoutParams.gravity = Gravity.CENTER;
            ProgressBar pbLoading = (ProgressBar) loadingView.findViewById(R.id.pb_loading);

            this.addView(loadingView, layoutParams);
        } else {
//            rotateAnimation.start();
            loadingView.setVisibility(VISIBLE);
        }
    }

    private void showErrorView() {
        if (errorView == null) {
            errorView = (LinearLayout) layoutInflater.inflate(R.layout.layout_error_view, null);
            errorView.setTag(ERROR_TAG);
            btn_error = (TextView) errorView.findViewById(R.id.btn_try);
            layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            this.addView(errorView, layoutParams);
        } else {
            errorView.setVisibility(VISIBLE);
        }
    }


    private void hideLoadingView() {
        if (loadingView != null && loadingView.getVisibility() != GONE) {
            loadingView.setVisibility(GONE);
        }
    }

    private void hideErrorView() {
        if (errorView != null && errorView.getVisibility() != GONE) {
            errorView.setVisibility(GONE);
        }
    }

    private void hideContentView() {
        if (contentViews != null) {
            for (View contentView : contentViews) {
                contentView.setVisibility(GONE);
            }
        }
    }

    public void setContentVisibility(boolean visible) {
        for (View contentView : contentViews) {
            contentView.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }
}
