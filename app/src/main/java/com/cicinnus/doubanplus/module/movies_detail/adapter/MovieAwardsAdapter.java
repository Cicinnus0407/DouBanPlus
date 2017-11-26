package com.cicinnus.doubanplus.module.movies_detail.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.CustomBaseViewHolder;
import com.cicinnus.doubanplus.module.movies_detail.model.MovieDetailModel;
import com.cicinnus.doubanplus.utils.StringUtils;

import java.util.List;

/**
 * Created by Cicinnus
 * on 2017/11/26.
 */

public class MovieAwardsAdapter extends BaseQuickAdapter<MovieDetailModel.Award, CustomBaseViewHolder> {
    public MovieAwardsAdapter() {
        super(R.layout.item_movie_award);
    }

    @Override
    protected void convert(CustomBaseViewHolder helper, MovieDetailModel.Award item) {
        helper.setText(R.id.tv_award_name, String.format("%s %s", item.getAwardName(), item.getAwardCondition()))
                .setText(R.id.tv_award_people, StringUtils.getStringFromIterator(item.getAwardPeopleList().iterator(), "/"));
    }
}
