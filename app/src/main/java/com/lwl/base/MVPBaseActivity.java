package com.lwl.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;


/**
 * Created by uk on 2017/3/29.
 */

public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mBasePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //使用了MVP模式的activity
        if (getPresenter() != null) {
            mBasePresenter = (T) getPresenter();
            mBasePresenter.attachView((V) this);
        }
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    protected void initView() {}
    protected void initData() {}
    protected void initListener() {}

    /**
     * 获取布局id
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 获取presenter
     * @return
     */
    protected abstract T getPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBasePresenter != null) {
            mBasePresenter.detachView();
        }
    }
}
