package com.cicinnus.doubanplus.module.movies_detail.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.module.movies_detail.model.CastsModel;

/**
 * Created by Cicinnus
 * on 2017/11/25.
 */

public class MovieCastsAdapter extends BaseQuickAdapter<CastsModel,BaseViewHolder> {
    public MovieCastsAdapter() {
        super(R.layout.item_movie_cast);
    }

    @Override
    protected void convert(BaseViewHolder helper, CastsModel item) {
        helper.setText(R.id.tv_name,item.getName())
                .setText(R.id.tv_role,item.getRole());
        ImageView ivStar = helper.getView(R.id.iv_movie_star);
        Glide.with(ivStar.getContext()).load(item.getAvatar()).into(ivStar);
    }
}
