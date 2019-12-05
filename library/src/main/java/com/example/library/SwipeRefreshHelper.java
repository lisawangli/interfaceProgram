package com.example.library;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * 下拉刷新的帮助类
 */
public class SwipeRefreshHelper {
    private SwipeRefreshLayout swipeRefresh;

    public void setSwipeRefreshListener(SwipeRefreshListener swipeRefreshListener) {
        this.swipeRefreshListener = swipeRefreshListener;
    }

    private SwipeRefreshListener swipeRefreshListener;

    public SwipeRefreshHelper(SwipeRefreshLayout swipeRefresh) {
        this.swipeRefresh = swipeRefresh;
        init();
    }

    @SuppressLint("ResourceAsColor")
    private void init() {
        swipeRefresh.setColorSchemeColors(android.R.color.holo_orange_dark,android.R.color.holo_green_dark,android.R.color.holo_blue_dark);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (swipeRefreshListener!=null)
                    swipeRefreshListener.onRefresh();
            }
        });
    }

    static SwipeRefreshHelper createSwipeRefreshHelper(SwipeRefreshLayout swipeRefresh){
        return new SwipeRefreshHelper(swipeRefresh);
    }

    public interface SwipeRefreshListener{
        void onRefresh();
    }
}
