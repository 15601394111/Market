package com.jy.market.base;

import com.jy.market.interfases.IBasePresenter;
import com.jy.market.interfases.IBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Boss on 2020/3/3.
 */

//创建P层基类实现P层接口关联V层 重写接口方法
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V>{

    //保存泛型对象
    protected V mView;
    private WeakReference<V> mWeakReference;
    //保存一个mCompositeDisposable
    private CompositeDisposable mCompositeDisposable;


    @Override
    public void attachView(V view) {
        //实例化弱引用对象传入引用的类型返回对象全局变量
        mWeakReference = new WeakReference<>(view);
        //保存的泛型接收弱引用对象
        mView = mWeakReference.get();
    }

    @Override
    public void dattachView() {
        //清空V层;
        mView = null;
        //如果CompositeDisposable对象存在并且其中的元素个数大于0，那么打断所有元素的订阅关系
        if (mCompositeDisposable != null && mCompositeDisposable.size() > 0){
            mCompositeDisposable.dispose();
        }
    }

    //创建方法，用来创建CompositeDisposable对象 此处要用public修饰
    public void addDisposable(Disposable disposable){
        //如果没有CompositeDisposable实力对象,那么实例化其对象
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        //然后添加Disposable对象
        mCompositeDisposable.add(disposable);
    }
}
