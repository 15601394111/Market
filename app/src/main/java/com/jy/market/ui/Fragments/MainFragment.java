package com.jy.market.ui.Fragments;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jy.market.R;
import com.jy.market.base.BaseFragment;
import com.jy.market.constract.MainConstract;
import com.jy.market.interfases.IBasePresenter;
import com.jy.market.models.beans.IndexBean;
import com.jy.market.presenters.MainPresenter;
import com.jy.market.ui.adapters.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainFragment extends BaseFragment implements MainConstract.View {

    @BindView(R.id.txt_title)
    TextView mTxtTitle;
    @BindView(R.id.rectlerview)
    RecyclerView mRectlerview;
    private View view;
    private Unbinder unbinder;

    List<IndexBean.DataBean.BrandListBean> mBrandListBeans;
    MainAdapter mMainAdapter;

    @Override
    public void showError(String error) {

    }

    @Override
    public void getIndexDataReturn(IndexBean result) {
        mMainAdapter.upData(mBrandListBeans);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        mTxtTitle.setText("品牌制造商");
        mBrandListBeans = new ArrayList<>();
        mRectlerview.setLayoutManager(new GridLayoutManager(mContext,2));
        mMainAdapter = new MainAdapter(mContext,mBrandListBeans);
        mRectlerview.setAdapter(mMainAdapter);
    }

    @Override
    protected void initData() {
        ((MainPresenter) presenter).getMainData();
    }

    @Override
    protected IBasePresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
