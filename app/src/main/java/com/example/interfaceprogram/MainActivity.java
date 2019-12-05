package com.example.interfaceprogram;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.library.ItemListener;
import com.example.library.RViewAdapter;
import com.example.library.RViewHolder;
import com.example.library.RViewItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseRViewActivity {
    private List<UserInfo> datas = new ArrayList<>();
//    private RViewAdapter adapter;
    private MultiAdapter adapter;
    private Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSwipeRefresh();
        createRecycleView();
        initView();
        initDatas();
        listener();
    }

    private void initDatas() {
//        if (datas.isEmpty()){
//            for (int i = 0; i < 100; i++) {
//                datas.add(new UserInfo("test",i));
//            }
//        }
//        notifyAdapterDataChanged(datas);
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (datas.isEmpty()){
                    for (int i = 0; i < 15; i++) {
                        for (int j = i; j <=15 ; j++) {
                            UserInfo userInfo = new UserInfo("test"+i*j,i*j);
                            if(j%15==1){
                                userInfo.setType(3);
                                userInfo.setAccount(">>>111111>>>>>");
                            }else if(j%15==7|| j%15==8){
                                userInfo.setType(2);
                                userInfo.setAccount(">>>>222222>>>>");
                            }else if (j%15==4||j%15==5||j%15==6){
                                userInfo.setType(5);
                                userInfo.setAccount(">>>>>33333>>>");
                            }else if (j%15==7||j%15==8||j%15==9||j%15==10){
                                userInfo.setType(4);
                                userInfo.setAccount(">>>>>4444>>>");
                            }else{
                                userInfo.setType(1);
                                userInfo.setAccount(">>>>>1111>>>>>>>");
                            }
                            datas.add(userInfo);
                        }
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        notifyAdapterDataChanged(datas);

                    }
                });
            }

        }).start();
    }

    private void listener() {
        adapter.setItemListener(new ItemListener<UserInfo>() {
            @Override
            public void onItemClick(View view, UserInfo entity, int position) {
                Toast.makeText(MainActivity.this,"onItemClick Position >>>"+position,Toast.LENGTH_LONG).show();
            }

            @Override
            public boolean onItemLongClick(View view, UserInfo entity, int position) {
                Toast.makeText(MainActivity.this,"onItemClick Position >>>"+position,Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    public RViewAdapter createRecyclevViewAdapter() {
//        adapter = new RViewAdapter<>(datas, new RViewItem<UserInfo>() {
//            @Override
//            public int getItemLayout() {
//                return R.layout.item_test;
//            }
//
//            @Override
//            public boolean openClick() {
//                return true;
//            }
//
//            @Override
//            public void convert(RViewHolder holder, UserInfo entity, int position) {
//                TextView name = holder.getView(R.id.name);
//                name.setText("姓名："+entity.getName());
//                TextView age = holder.getView(R.id.age);
//                age.setText("年龄："+entity.getAge());
//            }
//
//            @Override
//            public boolean isItemView(UserInfo entity, int postion) {
//                return true;
//            }
//        });
        adapter = new MultiAdapter(datas);
        return adapter;
    }

    @Override
    public void onRefresh() {
        initDatas();
    }
}
