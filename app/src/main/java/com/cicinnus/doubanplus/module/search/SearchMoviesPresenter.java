package com.cicinnus.doubanplus.module.search;

import android.app.Activity;

import com.cicinnus.corelib.base.BaseMvpPresenter;
import com.cicinnus.corelib.rx.SchedulersCompact;
import com.cicinnus.doubanplus.utils.ExceptionHandle;

import io.reactivex.functions.Consumer;

/**
 * Created by Cicinnus
 * on 2017/11/23.
 */

public class SearchMoviesPresenter extends BaseMvpPresenter<SearchMovieContract.ISearchMoviesView> implements SearchMovieContract.ISearchMoviesPresenter {

    SearchDataSource searchDataSource = new SearchDataSource();

    public SearchMoviesPresenter(Activity activity, SearchMovieContract.ISearchMoviesView view) {
        super(activity, view);
    }

    @Override
    public void searchMovies(String keyword, final int start) {
        if (start == 0) {
            mView.showLoading();
        }
        addSubscribeUntilDestroy(searchDataSource.searchMovies(keyword, start)
                .compose(SchedulersCompact.<SearchResultBean>applyIoSchedulers())
                .subscribe(new Consumer<SearchResultBean>() {
                    @Override
                    public void accept(SearchResultBean searchResultBean) throws Exception {
                        if (start == 0) {
                            mView.addSearchResult(searchResultBean.getSubjects());
                            mView.showContent();
                        } else {
                            mView.addMoreSearchResult(searchResultBean.getSubjects());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (start==0) {
                            mView.showError(ExceptionHandle.handleException(throwable));
                        }else {
                            mView.loadMoreError(ExceptionHandle.handleException(throwable));
                        }
                    }
                }));
    }
}
