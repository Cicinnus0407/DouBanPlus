package com.cicinnus.doubanplus.module.movies_detail;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.BaseActivity;

import butterknife.BindView;

/**
 * 电影详情
 *
 * @author Cicinnus
 *         on 2017/11/24.
 */

public class MovieDetailActivity extends BaseActivity<MovieDetailPresenter> implements MovieDetailContract.IMovieDetailContractView {


    @BindView(R.id.iv_movie_img)
    ImageView ivMovieImg;


    public static void start(Context context) {
        Intent starter = new Intent(context, MovieDetailActivity.class);
        context.startActivity(starter);
    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected MovieDetailPresenter getCorePresenter() {
        return new MovieDetailPresenter(mContext,this);
    }

    @Override
    protected void initEventAndData() {


        mPresenter.getMovieDetail("3231742");

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(String errorMsg) {

    }

    @Override
    public void addMovieDetail(MovieDetailBean movieDetailBean) {
        Glide.with(mContext).load(movieDetailBean.getImages().getLarge())
                .into(ivMovieImg);
    }


    @Override
    public boolean onNavigateUp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }

    }
}
