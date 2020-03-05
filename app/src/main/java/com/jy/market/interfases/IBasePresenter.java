package com.jy.market.interfases;

/**
 * Created by Boss on 2020/3/3.
 */

//创建P层接口关联V层接口
public interface IBasePresenter<V extends IBaseView> {

    //定义关联方法
    void attachView(V view);

    //定义打断方法
    void dattachView();

}
