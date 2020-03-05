package com.jy.market.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jy.market.interfases.IBasePresenter;
import com.jy.market.interfases.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Boss on 2020/3/3.
 */

//创建Fragment基类，继承系统的Fragment 关联P层实现V层接口
public abstract class BaseFragment<P extends IBasePresenter> extends Fragment implements IBaseView{

    protected P presenter;
    protected Unbinder mUnbinder;
    protected Context mContext;
    protected Activity mActivity;

    //重写系统两个方法
    //加载布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mContext = getContext();
        mActivity = getActivity();

        View view = LayoutInflater.from(mContext).inflate(getLayoutId(), null);
        return view;
    }

    //初始化界面
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //绑定ButterKnife返回对象全局变量
        mUnbinder = ButterKnife.bind(mContext,view);
        //基类P层接收子类返回的P层对象
        presenter = initPresenter();
        //如果存在P层对象绑定对象V层
        if (presenter != null){
            presenter.attachView(this);
        }
        //调用模板方法
        initView();
        initData();
        initListener();
    }

    //创建模板方法
    //获取布局
    protected abstract int getLayoutId();

    //初始化控件
    protected void initView(){};

    //获取数据
    protected void initData(){};

    //监听
    protected void initListener(){};

    //初始化P层
    protected abstract P initPresenter();

    //重写系统销毁方法
    @Override
    public void onDestroy() {
        super.onDestroy();
        //如果P层存在关联，那么打断关联；
        if (presenter != null){
            presenter.dattachView();
        }

        //如果ButterKnife是绑定状态，那么解绑；
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
