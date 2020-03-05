package com.jy.market.apps;

import android.app.Application;

/**
 * Created by Boss on 2020/3/3.
 */
//创建一个类 继承系统 Application
public class MyApplication extends Application {

    //保存公共一个静态变量、
    public static MyApplication sMyApplication;

    //重写OnCreate方法
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化值
        sMyApplication = this;
    }

    //清单文件application中捆绑
    /* <application
        android:allowBackup="true"
        android:name=".apps.MyApplication"
        */
}
