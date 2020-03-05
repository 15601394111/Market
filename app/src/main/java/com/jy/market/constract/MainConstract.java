package com.jy.market.constract;

import com.jy.market.interfases.IBasePresenter;
import com.jy.market.interfases.IBaseView;
import com.jy.market.models.beans.IndexBean;

/**
 * Created by Boss on 2020/3/5.
 */

public interface MainConstract {

    interface View extends IBaseView{
        void getIndexDataReturn(IndexBean result);
    }

    interface Presenter extends IBasePresenter<View>{
        void getIndextData();
    }
}
