package com.jy.market.common;


import com.jy.market.apps.MyApplication;

import java.io.File;

public class Constant {

    public static final String BASE_WAN_URL = "https://www.wanandroid.com/"; //wanandroid基础地址

    public static final String BASE_SHOP_URL = "https://cdwan.cn/api/";  //商城的基础地址


    //网络缓存的地址
    public static final String PATH_DATA = MyApplication.sMyApplication.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/shop";


    public static final String PRICE_MODEL = "$元起";


}
