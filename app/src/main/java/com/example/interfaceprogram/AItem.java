package com.example.interfaceprogram;

import android.widget.TextView;

import com.example.library.RViewHolder;
import com.example.library.RViewItem;

public class AItem implements RViewItem<UserInfo> {

    @Override
    public int getItemLayout() {
        return R.layout.item_a;
    }

    @Override
    public boolean openClick() {
        return true;
    }

    @Override
    public void convert(RViewHolder holder, UserInfo entity, int position) {
        TextView textView = holder.getView(R.id.mtv);
        textView.setText("姓名："+entity.getName());
    }

    @Override
    public boolean isItemView(UserInfo entity, int postion) {
        return entity.getType() == 1;
    }
}
