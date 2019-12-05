package com.example.interfaceprogram;

import android.widget.TextView;

import com.example.library.RViewHolder;
import com.example.library.RViewItem;

public class CItem implements RViewItem<UserInfo> {

    @Override
    public int getItemLayout() {
        return R.layout.item_c;
    }

    @Override
    public boolean openClick() {
        return true;
    }

    @Override
    public void convert(RViewHolder holder, UserInfo entity, int position) {
        TextView textView = holder.getView(R.id.mtv);
        textView.setText("金额："+entity.getAccount());
    }

    @Override
    public boolean isItemView(UserInfo entity, int postion) {
        return entity.getType() == 3;
    }
}
