package com.jy.market.common;

import android.text.TextUtils;

import com.jy.market.interfases.IBaseView;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by Boss on 2020/3/3.
 */

//创建一个类继承系统ResourceSubscriber
//重写方法 拿掉onNext方法 将类修改为抽象类
public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {

    //保存一个V层对象
    private IBaseView mIBaseView;
    //保存错误信息的一个变量
    private String mError;

    //构造方法
    public CommonSubscriber(IBaseView iBaseView){
        this.mIBaseView = iBaseView;
    }

    public CommonSubscriber(IBaseView iBaseView,String error){
        this.mIBaseView = iBaseView;
        this.mError = error;
    }

    @Override
    public void onError(Throwable t) {

        if (mIBaseView != null){
            //如果错误对象不等于空，那么显示这个错误信息
            if (!TextUtils.isEmpty(mError)){
                mIBaseView.showError(mError);
            }

            //如果t.getMessage不为空证明有错误信息，那么显示这个错误信息。
            if (!TextUtils.isEmpty(t.getMessage())){
                mIBaseView.showError(t.getMessage());
            }
        }

    }

    @Override
    public void onComplete() {

    }
}
