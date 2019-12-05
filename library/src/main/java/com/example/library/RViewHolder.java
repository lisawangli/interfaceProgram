package com.example.library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RViewHolder extends RecyclerView.ViewHolder {

    //一个条目的布局，有多个控件
    private SparseArray<View> mViews;
    private View mConvertView;//当前view对象

    public RViewHolder(View itemView) {
        super(itemView);
        mConvertView = itemView;
        mViews = new SparseArray<>();
    }

    public static RViewHolder createViewHolder(Context context, ViewGroup parent,int layoutId){
        View itemView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        return new RViewHolder(itemView);
    }

    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view==null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }


    public View getmConvertView(){
        return mConvertView;
    }
}
