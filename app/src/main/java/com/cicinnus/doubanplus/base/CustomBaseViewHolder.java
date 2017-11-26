package com.cicinnus.doubanplus.base;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Cicinnus
 * on 2017/11/26.
 */

public class CustomBaseViewHolder extends BaseViewHolder {
    public CustomBaseViewHolder(View view) {
        super(view);
    }


    public BaseViewHolder loadImage(@IdRes int viewId,String url) {
        ImageView imageView = super.getView(viewId);
        Glide.with(imageView.getContext()).load(url).into(imageView);
        return this;
    }
}
