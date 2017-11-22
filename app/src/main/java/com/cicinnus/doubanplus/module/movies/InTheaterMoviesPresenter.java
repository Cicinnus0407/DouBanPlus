package com.cicinnus.doubanplus.module.movies;

import android.app.Activity;

import com.cicinnus.corelib.base.BaseMvpPresenter;
import com.cicinnus.corelib.rx.SchedulersCompact;
import com.cicinnus.doubanplus.module.movies.bean.ComingMovieBean;
import com.cicinnus.doubanplus.module.movies.bean.InTheaterMoviesBean;
import com.cicinnus.doubanplus.utils.ExceptionHandle;
import com.orhanobut.logger.Logger;

import io.reactivex.functions.Consumer;

/**
 * @author Cicinnus
 *         on 2017/11/21.
 */

public class InTheaterMoviesPresenter extends BaseMvpPresenter<IMoviesContract.ITheaterMoviesView> implements IMoviesContract.IMoviesPresenter {

    InTheaterMoviesDataSource dataSource = new InTheaterMoviesDataSource();

    public InTheaterMoviesPresenter(Activity activity, IMoviesContract.ITheaterMoviesView view) {
        super(activity, view);
    }

    @Override
    public void getTheaterMovies(final int start) {
        if (start == 0) {
            mView.showLoading();
        }
        addSubscribeUntilDestroy(dataSource.getInTheaterMovies(start)
                .compose(SchedulersCompact.<InTheaterMoviesBean>applyIoSchedulers())
                .subscribe(new Consumer<InTheaterMoviesBean>() {
                    @Override
                    public void accept(InTheaterMoviesBean inTheaterMoviesBean) throws Exception {
                        //获取数据,判断是0则是第一次获取数据,否则是加载更多的数据
                        if (start == 0) {
                            mView.addTheaterMovies(inTheaterMoviesBean.getSubjects());
                            mView.showContent();
                        } else {
                            mView.addMoreTheaterMovies(inTheaterMoviesBean.getSubjects());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (start == 0) {
                            mView.showError(ExceptionHandle.handleException(throwable));
                        } else {
                            mView.loadMoreFail(ExceptionHandle.handleException(throwable));
                        }
                    }
                }));
    }

    @Override
    public void getComingMovies(final int start) {
        if (start == 0) {
            mView.showLoading();
        }
        addSubscribeUntilDestroy(dataSource.getComingMovies(start)
                .compose(SchedulersCompact.<ComingMovieBean>applyIoSchedulers())
                .subscribe(new Consumer<ComingMovieBean>() {
                    @Override
                    public void accept(ComingMovieBean comingMovieBean) throws Exception {
                        //获取数据,判断是0则是第一次获取数据,否则是加载更多的数据
                        if (start == 0) {
                            mView.addComingMovies(comingMovieBean.getSubjects());
                            mView.showContent();
                        } else {
                            mView.addMoreComingMovies(comingMovieBean.getSubjects());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                        if (start == 0) {
                            mView.showError(ExceptionHandle.handleException(throwable));
                        } else {
                            mView.loadMoreFail(ExceptionHandle.handleException(throwable));
                        }
                    }
                }));
    }
}
