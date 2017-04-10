package com.lwl.video.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.lwl.base.MVPBaseFragment;
import com.lwl.video.modle.bean.TitleBean;
import com.lwl.video.view.IFragment.IVideoFgView;
import com.lwl.video.psenter.VideoPersent;
import com.lwl.neteasenews.R;
import com.lwl.video.modle.bean.VideoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by zewen Administrator on 2017/4/8 0008.
 * email 1350495049@qq.com
 * use :
 */

public class VideoFragment extends MVPBaseFragment<IVideoFgView,VideoPersent> implements IVideoFgView{

    @Bind(R.id.video_toobar)
    Toolbar toolbar;
    @Bind(R.id.video_vp)
    ViewPager viewPager;
    @Bind(R.id.video_tab)
    TabLayout tabLayout;


    private MyPagerAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fg_video;
    }


    @Override
    protected void initData() {
        super.initData();


        mPresenter.show();

        //设置适配器为Vp
        adapter = new MyPagerAdapter();
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected VideoPersent getPresenter() {
        return new VideoPersent();
    }

    /**
     * 返回的数据
     * @param beanList
     */
    @Override
    public void back(List<TitleBean> beanList) {
        List<VideoPager> videoPagers = new ArrayList<>();
        for (int i = 0; i < beanList.size(); i++) {
            videoPagers.add(new VideoPager(getActivity()));
        }
        adapter.setData(videoPagers,beanList);

        tabLayout.addOnTabSelectedListener(new MyOnTabSelectedListener(videoPagers));

        //默认加载第一页的数据
        videoPagers.get(0).initData();
    }

    /**
     * Vp的适配器
     */
    class MyPagerAdapter extends PagerAdapter{

        private List<VideoPager> videoPagers = null;
        private List<TitleBean> beanList = null;

        public MyPagerAdapter() {
            this.videoPagers = new ArrayList<>();
            this.beanList = new ArrayList<>();
        }

        public void setData(List<VideoPager> videoPagers,List<TitleBean> beanList){
            this.videoPagers.addAll(videoPagers);
            this.beanList.addAll(beanList);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return videoPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return beanList.get(position).getMovieName();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            VideoPager pager = videoPagers.get(position);

            container.addView(pager.rootView);

            return pager.rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    //tabLayout的监听
    class MyOnTabSelectedListener implements TabLayout.OnTabSelectedListener{
        List<VideoPager> videoPagers = null;
        public MyOnTabSelectedListener(List<VideoPager> videoPagers) {
            this.videoPagers = videoPagers;
        }

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            int position = tab.getPosition();
            videoPagers.get(position).initData();

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

}
