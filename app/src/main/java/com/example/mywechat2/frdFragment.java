package com.example.mywechat2;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

public class frdFragment extends Fragment {

    private static final String TAG = frdFragment.class.getSimpleName();

    private RecyclerView recyclerView;
    private TextView tvArea;
    private List<String> fList = new ArrayList<>();
    private List<StickyData> fDataList = new ArrayList<>();
    private Context context;
    private adapter adapter;

    public frdFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.tab02, container, false);

        recyclerView=view.findViewById(R.id.recycleview);
        tvArea=view.findViewById(R.id.tv_sticky_header_view);

        initList();
        initData();
        initView();

        return view;
    }
    private void initList() {
        fList.add("粤菜|👍😋🐟精品虾饺王🐟😋👍");
        fList.add("粤菜|🌶驰名马来咖喱饭🌶");
        fList.add("粤菜|🐖秘制南乳猪手🐖");
        fList.add("粤菜|瑞士汁鸡翼");
        fList.add("粤菜|🐟至潮鱼蛋片头河🐟");
        fList.add("鄂菜|🌶🥔恩施有机土豆🥔🌶");
        fList.add("鄂菜|🌶🌶生炒口味鸡🌶🌶");
        fList.add("鄂菜|🐟清蒸武昌鱼🐟");
        fList.add("鄂菜|🥔🌶干锅土豆片🌶🥔");
        fList.add("鄂菜|🥚肉末鸡蛋豆腐🥚");
        fList.add("川菜|🌶🐟水煮鱼片🐟🌶");
        fList.add("川菜|🌶🌶🌶香干回锅肉🌶🌶🌶");
        fList.add("川菜|🐟🌶红烧草鱼头🌶🐟");
        fList.add("川菜|🌶🌶🐟秘制酸菜鱼🌶🌶🐟");
        fList.add("鲁菜|😋东北特色酱大骨😋");
        fList.add("鲁菜|猪肉韭菜饺子");
        fList.add("鲁菜|👍🍠拔丝地瓜🍠👍");

    }

    private void initData() {
        for (int i = 0; i < fList.size(); i++) {
            StickyData bean = new StickyData();

            String s = fList.get(i);
            // area
            String area = s.substring(0, s.indexOf("|"));
            // team
            String team = s.substring(s.indexOf("|") + 1, s.length());

            bean.setArea(area);
            bean.setTeam(team);

            fDataList.add(bean);
        }

        Log.d(TAG, "initData: " + fDataList.size());
    }

    private void initView() {
        context=this.getActivity();
        adapter=new adapter(context,fDataList);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                View stickyInfoView = recyclerView.findChildViewUnder(
                        tvArea.getMeasuredWidth() / 2, 5);

                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {
                    tvArea.setText(String.valueOf(stickyInfoView.getContentDescription()));
                }

                View transInfoView = recyclerView.findChildViewUnder(
                        tvArea.getMeasuredWidth() / 2, tvArea.getMeasuredHeight() + 1);

                if (transInfoView != null && transInfoView.getTag() != null) {

                    int transViewStatus = (int) transInfoView.getTag();
                    int dealtY = transInfoView.getTop() - tvArea.getMeasuredHeight();

                    if (transViewStatus == adapter.HAS_STICKY_VIEW) {
                        if (transInfoView.getTop() > 0) {
                            tvArea.setTranslationY(dealtY);
                        } else {
                            tvArea.setTranslationY(0);
                        }
                    } else if (transViewStatus == adapter.NONE_STICKY_VIEW) {
                        tvArea.setTranslationY(0);
                    }
                }
            }
        });
    }
}

//import android.content.Context;
//        import android.os.Bundle;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//
//        import android.app.Fragment;
//
//        import androidx.recyclerview.widget.DividerItemDecoration;
//        import androidx.recyclerview.widget.LinearLayoutManager;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import java.util.ArrayList;
//        import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//public class frdFragment extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public frdFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment BlankFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static frdFragment newInstance(String param1, String param2) {
//        frdFragment fragment = new frdFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.tab02, container, false);
//    }
//}