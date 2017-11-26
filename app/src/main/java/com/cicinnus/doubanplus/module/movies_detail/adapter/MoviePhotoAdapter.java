package com.cicinnus.doubanplus.module.movies_detail.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.module.movies_detail.model.PicModel;

import java.util.List;

/**
 * Created by Cicinnus
 * on 2017/11/25.
 */

public class MoviePhotoAdapter extends BaseQuickAdapter<PicModel,BaseViewHolder> {
    public MoviePhotoAdapter() {
        super(R.layout.item_movie_photo);
    }

    @Override
    protected void convert(BaseViewHolder helper, PicModel item) {
        ImageView ivMoviePic = helper.getView(R.id.iv_movie_photo);
        Glide.with(ivMoviePic.getContext()).load(item.getUrl()).into(ivMoviePic);
    }
}
