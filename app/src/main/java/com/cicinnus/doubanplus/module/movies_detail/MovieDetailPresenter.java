package com.cicinnus.doubanplus.module.movies_detail;

import android.app.Activity;

import com.cicinnus.corelib.base.BaseMvpPresenter;
import com.cicinnus.corelib.rx.SchedulersCompact;
import com.cicinnus.doubanplus.utils.ExceptionHandle;

import io.reactivex.functions.Consumer;

/**
 * @author Cicinnus
 *         on 2017/11/24.
 */

public class MovieDetailPresenter extends BaseMvpPresenter<MovieDetailContract.IMovieDetailContractView> implements MovieDetailContract.IMovieDetailPresenter {

    private MovieDetailDataSource dataSource = new MovieDetailDataSource();

    public MovieDetailPresenter(Activity activity, MovieDetailContract.IMovieDetailContractView view) {
        super(activity, view);
    }

    @Override
    public void getMovieDetail(String movieId) {
        mView.showLoading();
        addSubscribeUntilDestroy(dataSource.getMovieDetail(movieId)
                .compose(SchedulersCompact.<MovieDetailBean>applyIoSchedulers())
                .subscribe(new Consumer<MovieDetailBean>() {
                    @Override
                    public void accept(MovieDetailBean movieDetailBean) throws Exception {
                        mView.addMovieDetail(movieDetailBean);
                        mView.showContent();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(ExceptionHandle.handleException(throwable));
                    }
                }));
    }
}
