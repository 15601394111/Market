package com.jy.market.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jy.market.common.Constant;

import java.util.List;

/**
 * Created by Boss on 2020/3/5.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {

    protected List<T> mData;
    protected Context mContext;
    ItemClickListener mItemClickListener;

    public BaseAdapter(Context context,List<T> list){
        mContext = context;
        mData = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(getLayoutId(), null);
        final BaseViewHolder baseViewHolder = new BaseViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null){
                    mItemClickListener.itemClick(baseViewHolder,baseViewHolder.getLayoutPosition());
                }
            }
        });
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        T data = mData.get(position);
        bindData((BaseViewHolder) holder,data);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void upData(List<T> list){
        mData.clear();
        mData.addAll(list);
        notifyDataSetChanged();
    }

    protected abstract int getLayoutId();
    protected abstract void bindData(BaseViewHolder holder,T data);

    public static class BaseViewHolder extends RecyclerView.ViewHolder {

        SparseArray views;

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            views = new SparseArray();
        }
        public View getView(int id){
            View view = (View) views.get(id);
            if (view == null){
                view = itemView.findViewById(id);
                views.append(id,view);
            }
            return view;
        }
    }

    public void addItemClickListener(ItemClickListener listener){
        mItemClickListener = listener;
    }

    public interface ItemClickListener{
        void itemClick(BaseViewHolder viewHolder,int position);

    }
}
