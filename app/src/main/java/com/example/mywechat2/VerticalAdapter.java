package com.example.mywechat2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {

    private static final String TAG = VerticalAdapter.class.getSimpleName();
    private Context mContext;
    private int[] mId;
    private List<String> mList = new ArrayList<>();
    private List<String> sList = new ArrayList<>();
    public VerticalAdapter(Context context) {
        mContext = context;
    }
    public class VerticalViewHolder extends RecyclerView.ViewHolder {

        TextView tvNum, tvContent;
        ImageView Img;

        public VerticalViewHolder(View itemView) {
            super(itemView);
            tvNum = itemView.findViewById(R.id.tv_num);
            tvContent = itemView.findViewById(R.id.tv_content);
            Img=itemView.findViewById(R.id.img);
        }
    }
    public void setVerticalDataList(List<String> list1,List<String> list2,int[] Id) {
        Log.d(TAG, "setVerticalDataList: " + list2.size());
        sList=list1;
        mList = list2;
        mId=Id;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycle, parent, false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        final int Img=mId[position];
        final String content = sList.get(position);
//        holder.tvNum.setText("  "+position+"");

        holder.tvNum.setText(sList.get(position));
        holder.tvContent.setText(mList.get(position));
        holder.Img.setImageResource(Img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "你刚刚下单了：" + content, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
}