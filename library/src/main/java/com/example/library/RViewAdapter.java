package com.example.library;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RViewAdapter<T> extends RecyclerView.Adapter<RViewHolder> {
    private RViewItemManager itemStyle;//item类型管理
    private ItemListener<T> itemListener;//条目点击监听
    private List<T> datas;//数据源

    //单样式
    public RViewAdapter(List<T> datas){
        if (datas==null)
            this.datas = new ArrayList<>();
        this.datas = datas;
        itemStyle = new RViewItemManager();
    }

    public RViewAdapter(List<T> datas,RViewItem<T> item){
        if (datas==null)
            this.datas = new ArrayList<>();
        this.datas = datas;
        itemStyle = new RViewItemManager();
        addItemStyle(item);
    }

    public void addItemStyle(RViewItem<T> item) {
        itemStyle.addStyles(item);
    }

    public void addDatas(List<T> datas){
        if (datas==null)
            return;
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void updateDatas(List<T> datas){
        if (datas==null)
            return;
        this.datas = datas;
        notifyDataSetChanged();
    }

    //是否有多样式RViewItem
    private boolean hasMultiStyle(){
        return itemStyle.getItemViewStylesCount()>0;
    }

    //根据postion获取当去item布局类型
    @Override
    public int getItemViewType(int position) {
        if (hasMultiStyle())
            return itemStyle.getItemViewType(datas.get(position),position);
        return super.getItemViewType(position);
    }

    //根据布局类型创建不同的item的viewholder
    @Override
    public RViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RViewItem item = itemStyle.getRViewItem(viewType);
        int layoutId = item.getItemLayout();
        RViewHolder holder = RViewHolder.createViewHolder(parent.getContext(),parent,layoutId);
        if (item.openClick())
            setListener(holder);
        return holder;
    }

    private void setListener(final RViewHolder holder) {
        holder.getmConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (itemListener!=null)
                    itemListener.onItemClick(v,datas.get(position),position);
            }
        });

        holder.getmConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();
                if (itemListener!=null){
                    itemListener.onItemLongClick(v,datas.get(position),position);
                    return true;
                }
                return false;
            }
        });
    }

    //将数据绑定到item的ViewHolder控件
    @Override
    public void onBindViewHolder(RViewHolder holder, int position) {

        convert(holder,datas.get(position));
    }

    private void convert(RViewHolder holder, T t) {
        itemStyle.convert(holder,t,holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return datas==null?0:datas.size();
    }

    public void setItemListener(ItemListener<T> itemListener) {
        this.itemListener = itemListener;
    }
}
