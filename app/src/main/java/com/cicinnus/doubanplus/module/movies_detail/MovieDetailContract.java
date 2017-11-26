package com.cicinnus.doubanplus.module.movies_detail;

import com.cicinnus.corelib.base.ICoreLoadingView;
import com.cicinnus.doubanplus.module.movies_detail.model.MovieDetailModel;

/**
 * @author Cicinnus
 *         on 2017/11/24.
 */

public class MovieDetailContract {
    interface IMovieDetailContractView extends ICoreLoadingView{
        void addMovieDetail(MovieDetailModel movieDetailModel);
    }

    interface IMovieDetailPresenter{
        void getMovieDetail(String movieId);
    }
}
