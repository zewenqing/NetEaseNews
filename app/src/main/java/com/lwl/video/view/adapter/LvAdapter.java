package com.lwl.video.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lwl.neteasenews.R;
import com.lwl.video.modle.bean.TitleBean;
import com.lwl.video.modle.bean.VideoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zewen Administrator on 2017/4/8 0008.
 * email 1350495049@qq.com
 * use :
 */

public class LvAdapter extends BaseAdapter {

    private List<VideoBean> beanList;
    private Context context;
    private LayoutInflater inflater;

    public LvAdapter(Context context) {
        this.beanList = new ArrayList<>();
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<VideoBean> beanList){
        this.beanList.addAll(beanList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       LvHolder holder = null;
        if (convertView==null){
           convertView= inflater.inflate(R.layout.item_lv_play, parent, false);
            holder = new LvHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (LvHolder) convertView.getTag();
        }
        VideoBean bean = beanList.get(position);
        holder.tv_title.setText(bean.getTitle());
        holder.tv_name.setText(bean.getSname());

        Glide.with(context).load(bean.getImg()).thumbnail(0.1f).into(holder.iv);
        Glide.with(context).load(bean.getImg()).into(holder.iv_icon);

        //绑定数据
        return convertView;
    }

    class LvHolder {
        ImageView iv,iv_icon;
        TextView tv_title,tv_name;
        Button btn_dingyu,btn_fenXiang,btn_shoucang;
        public LvHolder(View itemView) {
            iv = (ImageView) itemView.findViewById(R.id.item_lv_iv1);
            iv_icon = (ImageView) itemView.findViewById(R.id.item_lv_icon);
            tv_title = (TextView) itemView.findViewById(R.id.item_lv_title);
            tv_name = (TextView) itemView.findViewById(R.id.item_lv_name);
            btn_dingyu = (Button) itemView.findViewById(R.id.btn);
            btn_fenXiang = (Button) itemView.findViewById(R.id.btn_shared);
            btn_shoucang = (Button) itemView.findViewById(R.id.btn_shoucan);
        }
    }
}
