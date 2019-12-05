package com.example.interfaceprogram;

import android.widget.TextView;

import com.example.library.RViewHolder;
import com.example.library.RViewItem;

public class BItem implements RViewItem<UserInfo> {

    @Override
    public int getItemLayout() {
        return R.layout.item_b;
    }

    @Override
    public boolean openClick() {
        return true;
    }

    @Override
    public void convert(RViewHolder holder, UserInfo entity, int position) {
        TextView textView = holder.getView(R.id.mtv);
        textView.setText("年龄："+entity.getAge());
    }

    @Override
    public boolean isItemView(UserInfo entity, int postion) {
        return entity.getType() == 2;
    }
}
