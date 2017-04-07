package com.lwl.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;


/**
 * Created by uk on 2017/3/29.
 */

public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mBasePresenter;
    private Fragment showFragment;
    private FragmentManager mFragmentManager;

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
        mFragmentManager = getSupportFragmentManager();
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

    public void showFragment(int frameId, Fragment fragment)
    {
        //开启一个事务
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        //当前有fragment显示，先隐藏掉
        if (showFragment != null) {
            transaction.hide(showFragment);
        }
        //在管理器中查找需要显示的fragmnet
        Fragment fragmentByTag = mFragmentManager.findFragmentByTag(fragment.getClass().getName());
        if (fragmentByTag != null) {
            //显示
            transaction.show(fragmentByTag);
        }else{
            //新建
            transaction.add(frameId, fragment, fragment.getClass().getName());
            transaction.show(fragment);
        }
        transaction.commit();
        showFragment = fragmentByTag;
    }
}
