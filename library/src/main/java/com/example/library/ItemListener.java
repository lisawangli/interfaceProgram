package com.example.library;

import android.view.View;

/**
 * 条目点击监听
 * @param <T>
 */
public interface ItemListener<T> {

    void onItemClick(View view,T entity,int position);

    boolean onItemLongClick(View view,T entity,int position);
}
