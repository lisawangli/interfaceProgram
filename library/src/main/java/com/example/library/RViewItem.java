package com.example.library;

/**
 * 某一类item对象（属性/特性），当成是javaBean对象
 * @param <T>
 */
public interface RViewItem<T> {

    /**
     * 获取item布局
     * @return
     */
    int getItemLayout();

    /**
     * 是否开启点击
     * @return
     */
    boolean openClick();

    /**
     * 将item控件与需要显示的数据绑定
     * @param holder
     * @param entity
     * @param position
     */
    void convert(RViewHolder holder,T entity,int position);

    /**
     * 哪个条目用哪个布局，是否为当前item布局
     * @param entity
     * @return
     */

    boolean isItemView(T entity,int postion);
}
