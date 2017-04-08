package com.lwl.video.view;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lwl.MainActivity;
import com.lwl.neteasenews.R;
import com.lwl.video.modle.bean.VideoBean;
import com.lwl.video.psenter.PagerPersent;
import com.lwl.video.view.IFragment.IPagerView;
import com.lwl.video.view.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zewen Administrator on 2017/4/8 0008.
 * email 1350495049@qq.com
 * use :
 */

public class VideoPager implements IPagerView{
    private Context context;
    public View rootView ;
    @Bind(R.id.rv)
    RecyclerView recyclerView;
    @Bind(R.id.fl)
    FrameLayout frameLayout;
    @Bind(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private PagerPersent pagerPersent;
    private MyRecyclerViewAdapter adapter;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            swipeRefreshLayout.setRefreshing(false);
        }
    };


    public VideoPager(Context context) {
        rootView = View.inflate(context, R.layout.video_pager,null);
        this.context =context;
        ButterKnife.bind(this,rootView);

        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(2000);
                        handler.sendEmptyMessage(0);
                    }
                }).start();
            }
        });
    }

    public void initData(){
        //加载数据
        frameLayout.setVisibility(View.VISIBLE);
        pagerPersent = new PagerPersent(this);
        pagerPersent.show();

        //设置适配器
        adapter = new MyRecyclerViewAdapter(context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
    }

    /**
     * 返回的数据
     * @param beanList
     */
    @Override
    public void backVideoData(List<VideoBean> beanList) {
        frameLayout.setVisibility(View.GONE);
        adapter.setData(beanList);

        //设置点击事件
        adapter.setOnItemClickListener(new MyOnclick(beanList));
    }
    class MyOnclick implements MyRecyclerViewAdapter.OnItemClickListener{
        List<VideoBean> beanList;
        public MyOnclick(List<VideoBean> beanList) {
            this.beanList = beanList;
        }

        @Override
        public void click(int position) {
            Intent intent = new Intent(context,PlayActivity.class);
            intent.putExtra("psition",position);
            MainActivity activity = (MainActivity) context;
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.entry,R.anim.exit);
        }
    }

}
