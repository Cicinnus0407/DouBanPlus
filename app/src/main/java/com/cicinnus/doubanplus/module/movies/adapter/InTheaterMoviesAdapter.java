package com.cicinnus.doubanplus.module.movies.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cicinnus.corelib.databinding.BaseBindingViewHolder;
import com.cicinnus.corelib.databinding.BaseDataBindingAdapter;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.databinding.ItemInTheaterMoviesBinding;
import com.cicinnus.doubanplus.module.movies.bean.InTheaterMoviesBean;

/**
 * @author Cicinnus
 *         on 2017/11/21.
 */

public class InTheaterMoviesAdapter extends BaseDataBindingAdapter<InTheaterMoviesBean.SubjectsBean, ItemInTheaterMoviesBinding> {
    public InTheaterMoviesAdapter() {
        super(R.layout.item_in_theater_movies);
    }


    @Override
    protected void convert(BaseBindingViewHolder<ItemInTheaterMoviesBinding> helper, ItemInTheaterMoviesBinding binding, InTheaterMoviesBean.SubjectsBean item) {
        binding.setBean(item);
        ImageView iv = helper.getView(R.id.iv_movie_img);
        Glide.with(iv).load(item.getImages().getLarge()).into(iv);
    }
}
