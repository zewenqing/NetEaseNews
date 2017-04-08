package com.lwl.video.view;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.lwl.base.MVPBaseActivity;
import com.lwl.neteasenews.R;
import com.lwl.video.modle.bean.TitleBean;
import com.lwl.video.modle.bean.VideoBean;
import com.lwl.video.psenter.PagerPersent;
import com.lwl.video.psenter.VideoPersent;
import com.lwl.video.view.IFragment.IPagerView;
import com.lwl.video.view.IFragment.IVideoFgView;
import com.lwl.video.view.adapter.LvAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class PlayActivity extends MVPBaseActivity<IPagerView,PagerPersent> implements IPagerView{
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.lv)
    ListView listView;
    @Bind(R.id.paly_fl)
    FrameLayout frameLayout;
    private ActionBar actionBar;
    private LvAdapter adapter;


    @Override
    protected void initView() {
        super.initView();
        toolbar.setTitle("加载更多");
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);;

    }

    @Override
    protected void initData() {
        super.initData();
        //设置适配器
        adapter = new LvAdapter(this);
        listView.setAdapter(adapter);

        //设置加载数据
        frameLayout.setVisibility(View.VISIBLE);
        getPresenter().show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_play;
    }

    @Override
    protected PagerPersent getPresenter() {
        return new PagerPersent(this);
    }

    /**
     * 返回的数据
     * @param beanList
     */
    @Override
    public void backVideoData(List<VideoBean> beanList) {
        //设置 加载数据完毕
        frameLayout.setVisibility(View.GONE);
        adapter.setData(beanList);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float down = 0;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                down = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getX()-down>0){
                    actionBar.setTitle("加载更多视频");
                }else {
                    actionBar.setTitle("");
                }

                break;

            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.entry,R.anim.exit);
                break;
        }
        return true;
    }


}

