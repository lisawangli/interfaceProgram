package com.example.interfaceprogram;

import com.example.library.RViewAdapter;

import java.util.List;

public class MultiAdapter extends RViewAdapter<UserInfo> {
    public MultiAdapter(List<UserInfo> datas) {
        super(datas);
        addItemStyle(new AItem());
        addItemStyle(new BItem());
        addItemStyle(new CItem());
        addItemStyle(new DItem());
        addItemStyle(new EItem());

    }
}
