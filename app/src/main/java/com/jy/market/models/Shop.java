package com.jy.market.models;

import com.jy.market.models.beans.IndexBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Boss on 2020/3/3.
 */

public interface Shop {

    @GET("index")
    Flowable<IndexBean> getIndexData();

}
