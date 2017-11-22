package com.cicinnus.doubanplus.module.movies.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cicinnus.corelib.databinding.BaseBindingViewHolder;
import com.cicinnus.corelib.databinding.BaseDataBindingAdapter;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.databinding.ItemComingMovieBinding;
import com.cicinnus.doubanplus.module.movies.bean.ComingMovieBean;

/**
 * @author Cicinnus
 *         on 2017/11/21.
 */

public class ComingMovieAdapter extends BaseDataBindingAdapter<ComingMovieBean.SubjectsBean, ItemComingMovieBinding> {
    public ComingMovieAdapter() {
        super(R.layout.item_coming_movie);
    }

    @Override
    protected void convert(BaseBindingViewHolder<ItemComingMovieBinding> helper, ItemComingMovieBinding binding, ComingMovieBean.SubjectsBean item) {
        binding.setBean(item);

        //影片类型
        TextView tvType = helper.getView(R.id.tv_movie_type);
        //显示所有的影片类型
        StringBuilder type = new StringBuilder();
        for (String s : item.getGenres()) {
            type.append(s).append(",");
        }
        if (type.length() > 1) {
            type.delete(type.length() - 1, type.length());
        }
        tvType.setText(type.toString());


        TextView tvCasts = helper.getView(R.id.tv_casts);
        StringBuilder casts = new StringBuilder();
        for (ComingMovieBean.SubjectsBean.CastsBean castsBean : item.getCasts()) {
            casts.append(castsBean.getName()).append(" , ");
        }
        if (casts.length() > 2) {
            casts.delete(casts.length() - 2, casts.length());
        }
        tvCasts.setText(casts.toString());


        //影片图片
        ImageView iv = helper.getView(R.id.iv_coming_movie);
        Glide.with(iv).load(item.getImages().getLarge()).into(iv);
    }
}
