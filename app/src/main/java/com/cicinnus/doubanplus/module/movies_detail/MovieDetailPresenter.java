package com.cicinnus.doubanplus.module.movies_detail;

import android.app.Activity;

import com.cicinnus.corelib.base.BaseMvpPresenter;
import com.cicinnus.corelib.rx.SchedulersCompact;
import com.cicinnus.doubanplus.module.movies_detail.model.MovieDetailModel;
import com.cicinnus.doubanplus.utils.ExceptionHandle;
import com.orhanobut.logger.Logger;

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
        addSubscribeUntilDestroy(dataSource.getMovieDetailModel(movieId)
                .compose(SchedulersCompact.<MovieDetailModel>applyIoSchedulers())
                .subscribe(new Consumer<MovieDetailModel>() {
                    @Override
                    public void accept(MovieDetailModel movieDetailModel) throws Exception {
                        mView.addMovieDetail(movieDetailModel);
                        mView.showContent();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                        mView.showError(ExceptionHandle.handleException(throwable));
                    }
                }));
    }
}
