package com.cicinnus.doubanplus.module.search;

import com.cicinnus.corelib.base.ICoreLoadingView;

import java.util.List;

/**
 * Created by Cicinnus
 * on 2017/11/23.
 */

public class SearchMovieContract {
    interface ISearchMoviesView extends ICoreLoadingView{
        void addMoreSearchResult(List<SearchResultBean.SubjectsBean> subjects);

        void addSearchResult(List<SearchResultBean.SubjectsBean> subjects);

        void loadMoreError(String s);
    }

    interface ISearchMoviesPresenter{
        void searchMovies(String keyword,int start);
    }
}
