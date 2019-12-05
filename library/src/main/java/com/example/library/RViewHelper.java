package com.example.library;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class RViewHelper<T> {
    private Context context;
    private SwipeRefreshLayout swipeRefresh;
    private SwipeRefreshHelper swipeRefreshHelper;
    private RecyclerView recyclerView;
    private RViewAdapter<T> adapter;
    private boolean isSupportPaging ;
    private int startPageNumber = 1;//是否支持加载更多
    private SwipeRefreshHelper.SwipeRefreshListener listener;
    private int currentPageNum;//当前页码

    public <T> RViewHelper(Builder builder) {
        this.swipeRefresh = builder.create.createSwipeRefresh();
        this.recyclerView = builder.create.createRecycleView();
        this.adapter = builder.create.createRecyclevViewAdapter();
        this.isSupportPaging = builder.create.isSupportPaging();
        this.context = builder.create.context();
        this.listener = builder.listener;
        this.currentPageNum = this.startPageNumber;
        if (swipeRefresh!=null){
            swipeRefreshHelper = SwipeRefreshHelper.createSwipeRefreshHelper(swipeRefresh);
        }
        init();
    }

    public void init(){
        //recyleView初始化
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if (swipeRefreshHelper!=null){
            swipeRefreshHelper.setSwipeRefreshListener(new SwipeRefreshHelper.SwipeRefreshListener() {
                @Override
                public void onRefresh() {
                    if (swipeRefresh.isRefreshing()){
                        swipeRefresh.setRefreshing(false);
                    }
                }
            });
        }
    }

    public void notifyAdapterDataSetChanged(List datas) {
        if (currentPageNum==startPageNumber){
            adapter.updateDatas(datas);
        }else {
            adapter.addDatas(datas);
        }
        Log.e("RViewHelper",datas+"=======111====");
        recyclerView.setAdapter(adapter);
        Log.e("RViewHelper","=======22222====");
    }

    public static class Builder<T>{
        private RViewCreate<T> create;//控件初始化
        private SwipeRefreshHelper.SwipeRefreshListener listener;//下拉刷新
        public Builder(RViewCreate<T> create, SwipeRefreshHelper.SwipeRefreshListener listener){
            this.create = create;
            this.listener = listener;
        }

        public RViewHelper builder(){
            return new RViewHelper(this);
        }
    }
}
