package com.lwl.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by uk on 2017/3/29.
 */

public class BasePresenter<V> {
    protected Reference<V> mReference;

    /**
     * 绑定视图
     */
    public void attachView(V view) {
        mReference = new WeakReference<V>(view);
    }

    /**
     * 获取视图
     */
    public V getView() {
       return mReference.get();
    }

    /**
     * 判断是否绑定
     */
    public boolean isBingView() {
       return mReference != null && mReference.get() != null;
    }
    /**
     * 解除绑定
     */
    public void detachView() {
        if (mReference!= null) {
            mReference.clear();
            mReference = null;
        }
    }
}
