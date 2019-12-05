package com.example.library;

import android.support.v4.util.SparseArrayCompat;

/**
 * 多类型，多样式 item管理器
 * @param <T>
 */
public class RViewItemManager<T> {

    //所有RViewItem集合，key viewType value RViewItem
    private SparseArrayCompat<RViewItem<T>> styles = new SparseArrayCompat<>();

    /**
     * 加入一个新的样式，类型，放置集合末尾
     * @param item
     */
    public  void addStyles(RViewItem<T> item) {
        if (item!=null)
            styles.put(styles.size(),item);
    }

    public int getItemViewStylesCount(){
        return styles.size();
    }

    /**
     * 根据数据源和位置返回某item类型的ViewType，（styles集合中的key）
     * @param entity
     * @param position
     * @return
     */
    public int getItemViewType(T entity,int position){
        for (int i = 0; i < styles.size() ; i++) {
            RViewItem<T> item = styles.valueAt(i);
            if (item.isItemView(entity,position)){
                return styles.keyAt(i);
            }
        }
        throw new IllegalArgumentException("布局异常");
    }

    public RViewItem getRViewItem(int viewType) {
        return styles.get(viewType);
    }

    public void convert(RViewHolder holder,T entity,int position){
        for (int i = 0; i < styles.size(); i++) {
            RViewItem<T> item = styles.valueAt(i);
            if (item.isItemView(entity,position)){
                item.convert(holder,entity,position);
            }
        }
    }
}
