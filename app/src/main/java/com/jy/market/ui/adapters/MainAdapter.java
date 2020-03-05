package com.jy.market.ui.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.market.R;
import com.jy.market.base.BaseAdapter;
import com.jy.market.models.beans.IndexBean;

import java.util.List;

/**
 * Created by Boss on 2020/3/6.
 */

public class MainAdapter extends BaseAdapter {
    public MainAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.brand_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, Object data) {
        IndexBean.DataBean.BrandListBean brandListBean = (IndexBean.DataBean.BrandListBean) mData.get(position);
        TextView txtName = (TextView) holder.getView(R.id.txt_name);
        TextView txtPrice = (TextView) holder.getView(R.id.txt_price);
        ImageView img = (ImageView) holder.getView(R.id.img);

        txtName.setText(brandListBean.getName());
        txtPrice.setText(brandListBean.getFloor_price()+"元起");
        Glide.with(mContext).load(brandListBean.getPic_url()).into(img);
    }

}
