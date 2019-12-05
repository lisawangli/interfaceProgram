package com.example.interfaceprogram;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.library.RViewCreate;
import com.example.library.RViewHelper;
import com.example.library.SwipeRefreshHelper;

import java.util.List;

public abstract class BaseRViewActivity extends AppCompatActivity implements RViewCreate,SwipeRefreshHelper.SwipeRefreshListener {
    private RViewHelper helper;



    public Context context(){
       return this;
   }

    @Override
    public SwipeRefreshLayout createSwipeRefresh() {

        return findViewById(R.id.swipeRefreshLayout);
    }

    @Override
    public RecyclerView createRecycleView() {
        return findViewById(R.id.recyclerView);
    }

    public void initView(){
        helper = new RViewHelper.Builder(this,this).builder();
    }
    @Override
    public boolean isSupportPaging() {
        return false;
    }

    public void notifyAdapterDataChanged(List datas){
        helper.notifyAdapterDataSetChanged(datas);
    }
}
