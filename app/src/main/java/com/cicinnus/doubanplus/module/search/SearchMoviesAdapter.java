package com.cicinnus.doubanplus.module.search;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.view.SimpleRatingBar;

/**
 * 搜索结果adapter
 * Created by Cicinnus
 * on 2017/11/23.
 */

public class SearchMoviesAdapter extends BaseQuickAdapter<SearchResultBean.SubjectsBean, BaseViewHolder> {


    private OnMovieItemClickListener onMovieItemClickListener;

    public SearchMoviesAdapter() {
        super(R.layout.item_search_movies_result);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final SearchResultBean.SubjectsBean item) {
        helper.setText(R.id.tv_movie_name, item.getTitle());

        //拼接演员名字
        StringBuilder builder = new StringBuilder();
        builder.append("影片主演: ");
        for (SearchResultBean.SubjectsBean.CastsBean castsBean : item.getCasts()) {
            builder.append(castsBean.getName()).append(" , ");
        }
        if (builder.length() > 2) {
            builder.delete(builder.length() - 2, builder.length());
        }


        LinearLayout llMovieName = new LinearLayout(helper.itemView.getContext());

        Context context = helper.itemView.getContext();
        //如果影片原名和国内片名不一样,显示原名
        if (item.getOriginal_title() != null && (!item.getTitle().equals(item.getOriginal_title()))) {
            helper.setText(R.id.tv_movie_origin_name, item.getOriginal_title())
                    .setVisible(R.id.tv_movie_origin_name, true);
        }

        //演员名字
        helper.setText(R.id.tv_movie_casts, builder.toString());
        ImageView ivMovie = helper.getView(R.id.iv_movie_img);
        Glide.with(ivMovie.getContext()).load(item.getImages().getLarge()).transition(DrawableTransitionOptions.withCrossFade()).into(ivMovie);

        //评分
        helper.setVisible(R.id.rb_star, item.getRating().getAverage() != 0);
        if (item.getRating().getAverage() != 0) {
            SimpleRatingBar ratingBar = helper.getView(R.id.rb_star);
            ratingBar.setRating((float) (item.getRating().getAverage() / 2));
        }
        //评分
        helper.setText(R.id.tv_none_star, item.getRating().getAverage() == 0 ? "暂无" : String.format("%s分", item.getRating().getAverage()));


        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MovieDetailActivity.start(mContext);
                if (onMovieItemClickListener != null) {
                    onMovieItemClickListener.onClick(helper.getView(R.id.iv_movie_img),item);
                }
            }
        });

    }

    public void setOnMovieItemClickListener(OnMovieItemClickListener onMovieItemClickListener) {
        this.onMovieItemClickListener = onMovieItemClickListener;
    }

    interface OnMovieItemClickListener{
        void onClick(View view,SearchResultBean.SubjectsBean bean);
    }


}
