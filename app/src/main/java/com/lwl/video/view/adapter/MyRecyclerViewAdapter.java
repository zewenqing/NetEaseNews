package com.lwl.video.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lwl.neteasenews.R;
import com.lwl.video.modle.OnTitleLoadeListener;
import com.lwl.video.modle.bean.VideoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zewen Administrator on 2017/4/8 0008.
 * email 1350495049@qq.com
 * use :
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<VideoBean> beanList ;
    private LayoutInflater inflater;
    private Context context;

    public MyRecyclerViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        beanList = new ArrayList<>();
        this.context = context;
    }
    public void setData(List<VideoBean> list){
        beanList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recyler, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        VideoBean bean = beanList.get(position);
        myHolder.textView.setText(bean.getTitle());
        Glide.with(context).load(bean.getImg()).into(myHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            imageView = ((ImageView) itemView.findViewById(R.id.iv_one));
            textView = ((TextView) itemView.findViewById(R.id.tv_one));

            //设置点击事件
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener!=null){
                        onItemClickListener.click(getLayoutPosition());
                    }
                }
            });
        }
    }
    //声明接口
    public interface OnItemClickListener{
        void click(int position);
    }
    public OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

}
