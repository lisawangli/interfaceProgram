package com.example.library;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

public interface RViewCreate<T> {
    Context context();

    /**
     * 创建SwipeRefresh下拉
     * @return
     */
    SwipeRefreshLayout createSwipeRefresh();

    /**
     * 创建RecycleView
     * @return
     */
    RecyclerView createRecycleView();

    /**
     * 创建recycleViewadapter
     * @return
     */
    RViewAdapter<T> createRecyclevViewAdapter();

    /**
     * 是否支持分页
     * @return
     */
    boolean isSupportPaging();
}
