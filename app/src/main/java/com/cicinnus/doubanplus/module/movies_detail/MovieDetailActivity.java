package com.cicinnus.doubanplus.module.movies_detail;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.BaseActivity;
import com.cicinnus.doubanplus.module.movies_detail.adapter.MovieAwardsAdapter;
import com.cicinnus.doubanplus.module.movies_detail.adapter.MovieCastsAdapter;
import com.cicinnus.doubanplus.module.movies_detail.adapter.MoviePhotoAdapter;
import com.cicinnus.doubanplus.module.movies_detail.adapter.MovieShortCommentAdapter;
import com.cicinnus.doubanplus.module.movies_detail.model.MovieDetailModel;
import com.cicinnus.doubanplus.utils.StringUtils;
import com.cicinnus.doubanplus.view.ExpandTextView;

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
    @BindView(R.id.tv_movie_name)
    TextView tvMovieName;
    @BindView(R.id.tv_movie_rating)
    TextView tvMovieRating;
    @BindView(R.id.tv_rating_count)
    TextView tvRatingCount;
    @BindView(R.id.tv_movie_type)
    TextView tvMovieType;
    @BindView(R.id.tv_year)
    TextView tvYear;
    @BindView(R.id.expandText_movie_Desc)
    ExpandTextView expandMovieDesc;
    @BindView(R.id.rv_movie_star)
    RecyclerView rvMovieStar;
    @BindView(R.id.rv_movie_photos)
    RecyclerView rvMoviePhotos;
    @BindView(R.id.rv_movie_awards)
    RecyclerView rvMovieAwards;
    @BindView(R.id.rv_movie_short_comment)
    RecyclerView rvShortComment;


    private MovieCastsAdapter castsAdapter;
    private MoviePhotoAdapter moviePhotoAdapter;
    private MovieAwardsAdapter movieAwardsAdapter;
    private MovieShortCommentAdapter shortCommentAdapter;

    public static void start(Context context, String id) {
        Intent starter = new Intent(context, MovieDetailActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected MovieDetailPresenter getCorePresenter() {
        return new MovieDetailPresenter(mContext, this);
    }

    @Override
    protected void initEventAndData() {

//        String id = getIntent().getStringExtra("id");
        mPresenter.getMovieDetail("3231742");

        initRv();
    }

    private void initRv() {
        //影人
        rvMovieStar.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        castsAdapter = new MovieCastsAdapter();
        rvMovieStar.setAdapter(castsAdapter);
        //图片
        rvMoviePhotos.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        moviePhotoAdapter = new MoviePhotoAdapter();
        rvMoviePhotos.setAdapter(moviePhotoAdapter);
        //获奖情况
        rvMovieAwards.setLayoutManager(new LinearLayoutManager(mContext));
        movieAwardsAdapter = new MovieAwardsAdapter();
        rvMovieAwards.setAdapter(movieAwardsAdapter);
        //短评
        rvShortComment.setLayoutManager(new LinearLayoutManager(mContext));
        shortCommentAdapter = new MovieShortCommentAdapter();
        rvShortComment.setAdapter(shortCommentAdapter);
//        rvShortComment.setItemAnimator(commentAnimator);

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
    public void addMovieDetail(MovieDetailModel movieDetailModel) {

        setMovieData(movieDetailModel);

    }

    /**
     * 设置电影信息
     *
     * @param movieDetailModel
     */
    private void setMovieData(MovieDetailModel movieDetailModel) {
        Glide.with(mContext).load(movieDetailModel.getImage())
                .into(ivMovieImg);
        tvMovieName.setText(movieDetailModel.getTitle());
        //评分
        tvMovieRating.setText(String.format("%s分", movieDetailModel.getRating()));
        //评分人数
        tvRatingCount.setText(String.format("(%s人评)", movieDetailModel.getRatingsCount()));
        //上映地点和时间
        tvYear.setText(StringUtils.getStringFromIterator(movieDetailModel.getReleaseInfoList().iterator(), " /"));
        //影片类型
        tvMovieType.setText(StringUtils.getStringFromIterator(movieDetailModel.getMovieTypeList().iterator(), " / "));

        expandMovieDesc.setText(movieDetailModel.getSummary());

        castsAdapter.setNewData(movieDetailModel.getCastsModel());
        moviePhotoAdapter.setNewData(movieDetailModel.getPicModel());
        movieAwardsAdapter.setNewData(movieDetailModel.getAwardList());
        shortCommentAdapter.setNewData(movieDetailModel.getShortComments());
    }


    @Override
    public void onBackPressed() {
        finishAfterTransition();

    }
}
