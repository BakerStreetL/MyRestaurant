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
    private List<String> sList = new ArrayList<>();
    private Context context;
    int[] imageId;
    private VerticalAdapter adapter;
    public weixinFragment() {
    }

    private void initData() {
        sList.add("  芝士龙虾焗意面");
        sList.add("  葱爆孜然牛肉");
        sList.add("  生炒口味鸡");
        sList.add("  鱼香肉末茄子");
        sList.add("  蟹黄拌面");
        sList.add("  干锅土豆片");
        sList.add("  辣椒炒肉");
        sList.add("  干香火爆鱿鱼须");
        sList.add("  铁板黑椒牛肉");
        sList.add("  肉末鸡蛋豆腐");
        sList.add("  甜豆香肠");
        sList.add("  恩施有机土豆");
        sList.add("  酸菜豆花鱼");
        sList.add("  红烧狮子头");

        mList.add("      波士顿龙虾、宽扁意面");
        mList.add("      新鲜大葱、M9牛肉");
        mList.add("      秘制酱料、正宗走地鸡");
        mList.add("      现杀鲈鱼、新鲜茄子");
        mList.add("      手剥精选阳澄湖大闸蟹膏");
        mList.add("      干锅土豆片");
        mList.add("      辣椒炒肉");
        mList.add("      干香火爆鱿鱼须");
        mList.add("      铁板黑椒牛肉");
        mList.add("      肉末鸡蛋豆腐");
        mList.add("      甜豆香肠");
        mList.add("      恩施有机土豆");
        mList.add("      酸菜豆花鱼");
        mList.add("      红烧狮子头");
        imageId= new int[]{
                R.drawable.food1,
                R.drawable.food1,
                R.drawable.food1,
                R.drawable.food1,
                R.drawable.food1,
                R.drawable.food7,
                R.drawable.food6,
                R.drawable.food8,
                R.drawable.food9,
                R.drawable.food10,
                R.drawable.food10,
                R.drawable.food1,
                R.drawable.food1,
                R.drawable.food1};
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
        adapter.setVerticalDataList(sList,mList,imageId);
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