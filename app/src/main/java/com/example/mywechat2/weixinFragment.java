package com.example.mywechat2;

import android.os.Bundle;
import android.content.Context;
import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class weixinFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<String> mList = new ArrayList<>();
    private Context context;
    private VerticalAdapter adapter;
    public weixinFragment() {
    }

    private void initData() {
        mList.add("暗裔剑魔-亚托克斯");
        mList.add("蒸汽机器人-布里茨");
        mList.add("诺克萨斯之手-德莱厄斯");
        mList.add("祖安狂人-蒙多医生");
        mList.add("无双剑姬-菲奥娜");
        mList.add("酒桶-古拉加斯");
        mList.add("锋意志-艾瑞莉娅");
        mList.add("武器大师-贾克斯");
        mList.add("虚空掠夺者-卡兹克");
        mList.add("盲僧-李青");
        mList.add("沙漠死神-内瑟斯");
        mList.add("永恒梦魇-魔腾");
        mList.add("巨魔之王-特朗德尔");
        mList.add("魂锁典狱长-锤石");
        mList.add("刀锋之影-泰隆");
        mList.add("符文法师-瑞兹");
        mList.add("放逐之刃-锐雯");
        mList.add("生化魔人-扎克");
        mList.add("雷霆咆哮-沃利贝尔");
        mList.add("策士统领-斯维因");
        mList.add("炼金术士-辛吉德");
        mList.add("披甲龙龟-拉莫斯");
        mList.add("傲之追猎者-雷恩加尔");
        mList.add("兽灵行者-乌迪尔");
        mList.add("德玛西亚之翼-奎因");
        mList.add("疾风剑豪-亚索");
    }

    private void initView_1() {
        context=this.getActivity();
        VerticalAdapter adapter = new VerticalAdapter(context);
        RecyclerView rcvVertical = recyclerView.findViewById(R.id.rcv_vertical);
        LinearLayoutManager managerVertical = new LinearLayoutManager(context);
        managerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        rcvVertical.setLayoutManager(managerVertical);
        rcvVertical.setHasFixedSize(true);
        rcvVertical.setAdapter(adapter);
        adapter.setVerticalDataList(mList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab01, container, false);
        recyclerView=view.findViewById(R.id.rcv_vertical);
        initData();
        initView_1();

        return view;

    }
}