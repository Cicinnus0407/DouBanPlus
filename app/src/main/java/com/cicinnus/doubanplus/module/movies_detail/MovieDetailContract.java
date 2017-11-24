package com.cicinnus.doubanplus.module.movies_detail;

import com.cicinnus.corelib.base.ICoreLoadingView;

/**
 * @author Cicinnus
 *         on 2017/11/24.
 */

public class MovieDetailContract {
    interface IMovieDetailContractView extends ICoreLoadingView{
        void addMovieDetail(MovieDetailBean movieDetailBean);
    }

    interface IMovieDetailPresenter{
        void getMovieDetail(String movieId);
    }
}
