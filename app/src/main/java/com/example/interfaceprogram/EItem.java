package com.example.interfaceprogram;

import android.widget.TextView;

import com.example.library.RViewHolder;
import com.example.library.RViewItem;

public class EItem implements RViewItem<UserInfo> {

    @Override
    public int getItemLayout() {
        return R.layout.item_e;
    }

    @Override
    public boolean openClick() {
        return true;
    }

    @Override
    public void convert(RViewHolder holder, UserInfo entity, int position) {
        TextView textView = holder.getView(R.id.info);
        textView.setText("打印所有信息："+entity.toString());
    }

    @Override
    public boolean isItemView(UserInfo entity, int postion) {
        return entity.getType() == 5;
    }
}
