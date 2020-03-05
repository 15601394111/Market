package com.jy.market.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jy.market.interfases.IBasePresenter;
import com.jy.market.interfases.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Boss on 2020/3/3.
 */
//继承系统Activity 实现V层接口
public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView{

    //保存泛型对象
    protected P presenter;
    protected Unbinder mUnbinder;

    //重写系统onCreate方法
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //调用系统设置布局方法传入获取布局方法
        setContentView(getLayoutId());
        //绑定ButterKnife返回对象全局变量
        mUnbinder = ButterKnife.bind(this);
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

    //定义模板方法

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
    protected void onDestroy() {
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
