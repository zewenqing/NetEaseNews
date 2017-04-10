package com.lwl.video.psenter;

import android.os.Handler;

import com.lwl.base.BasePresenter;
import com.lwl.video.modle.IVideoTitle;
import com.lwl.video.modle.IVideoTitleImp;
import com.lwl.video.modle.OnTitleLoadeListener;
import com.lwl.video.modle.bean.TitleBean;
import com.lwl.video.view.IFragment.IVideoFgView;
import com.lwl.video.modle.ILoadeVideoDataListener;
import com.lwl.video.modle.IVideoData;
import com.lwl.video.modle.IVideoDataImp;
import com.lwl.video.modle.bean.VideoBean;

import java.util.List;

/**
 * Created by zewen Administrator on 2017/4/8 0008.
 * email 1350495049@qq.com
 * use :
 */

public class VideoPersent extends BasePresenter<IVideoFgView> {

    private IVideoTitle iVideoTitle = null;
    private IVideoFgView iVideoFgView = null;

    Handler handler = new Handler();

    public VideoPersent() {
        iVideoTitle = new IVideoTitleImp();
    }
//http://route.showapi.com/578-6?showapi_appid=35239&showapi_sign=985226cd80d44137a2492bc4e987da03
    public void show(){
        iVideoTitle.backTitle(new OnTitleLoadeListener() {
            @Override
            public void backTitle(final List<TitleBean> beanList) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iVideoFgView = getView();
                        iVideoFgView.back(beanList);
                    }
                });
            }
        });
    }
}
