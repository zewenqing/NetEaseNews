package com.lwl.video.psenter;

import android.os.Handler;

import com.lwl.base.BasePresenter;
import com.lwl.video.modle.ILoadeVideoDataListener;
import com.lwl.video.modle.IVideoData;
import com.lwl.video.modle.IVideoDataImp;
import com.lwl.video.modle.bean.VideoBean;
import com.lwl.video.view.IFragment.IPagerView;

import java.util.List;


/**
 * Created by zewen Administrator on 2017/4/8 0008.
 * email 1350495049@qq.com
 * use :
 */

public class PagerPersent extends BasePresenter<IPagerView> {
    private IVideoData iVideoData;

    private IPagerView iPagerView;

    Handler handler = new Handler();

    public PagerPersent(IPagerView iPagerView) {
        this.iPagerView = iPagerView;
        iVideoData = new IVideoDataImp();
    }

    public void show(){
        iVideoData.backVideoData(new ILoadeVideoDataListener() {
            @Override
            public void LoadeBack(final List<VideoBean> beanList) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iPagerView.backVideoData(beanList);
                    }
                });
            }
        });
    }
}
