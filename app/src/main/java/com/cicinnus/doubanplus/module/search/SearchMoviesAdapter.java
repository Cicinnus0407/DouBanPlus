package com.cicinnus.doubanplus.module.search;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.doubanplus.R;

import java.util.List;

/**
 * Created by Cicinnus
 * on 2017/11/23.
 */

public class SearchMoviesAdapter extends BaseQuickAdapter<SearchResultBean.SubjectsBean, BaseViewHolder> {
    public SearchMoviesAdapter() {
        super(R.layout.item_search_movies_result);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchResultBean.SubjectsBean item) {
        helper.setText(R.id.tv_movie_name, item.getTitle());
        StringBuilder builder = new StringBuilder();
        for (SearchResultBean.SubjectsBean.CastsBean castsBean : item.getCasts()) {
            builder.append(castsBean.getName()).append(" , ");
        }
        if (builder.length() > 2) {
            builder.delete(builder.length() - 2, builder.length());
        }
        helper.setText(R.id.tv_movie_casts, builder.toString());
    }
}
