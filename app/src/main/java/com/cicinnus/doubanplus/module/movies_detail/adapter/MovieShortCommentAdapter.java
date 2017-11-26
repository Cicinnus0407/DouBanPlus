package com.cicinnus.doubanplus.module.movies_detail.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.CustomBaseViewHolder;
import com.cicinnus.doubanplus.module.movies_detail.model.MovieDetailModel;

/**
 * 短评adapter
 * Created by Cicinnus
 * on 2017/11/26.
 */

public class MovieShortCommentAdapter extends BaseQuickAdapter<MovieDetailModel.ShortComment, CustomBaseViewHolder> {
    public MovieShortCommentAdapter() {
        super(R.layout.item_movie_short_comment);
    }

    @Override
    protected void convert(CustomBaseViewHolder helper, MovieDetailModel.ShortComment item) {
        helper.setText(R.id.tv_comment_author, item.getAuthor())
                .setText(R.id.tv_comment_content, item.getContent())
                .setText(R.id.tv_comment_date, item.getDate())
                .setText(R.id.tv_likes_count, item.getLikeCnt());
    }
}
