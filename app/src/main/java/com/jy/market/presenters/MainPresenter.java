package com.jy.market.presenters;

import com.jy.market.base.BasePresenter;
import com.jy.market.common.CommonSubscriber;
import com.jy.market.constract.MainConstract;
import com.jy.market.models.HttpManager;
import com.jy.market.models.beans.IndexBean;
import com.jy.market.utils.RxUtils;

/**
 * Created by Boss on 2020/3/5.
 */

public class MainPresenter extends BasePresenter<MainConstract.View> implements MainConstract.Presenter{

    @Override
    public void getIndextData() {
        addDisposable(HttpManager.getInstance().getShop().getIndexData()
                .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView){
                    @Override
                    public void onNext(IndexBean indexBean) {
                        mView.getIndexDataReturn(indexBean);
                    }
                })
        );
    }
}
