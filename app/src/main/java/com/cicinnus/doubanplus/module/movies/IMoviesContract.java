package com.cicinnus.doubanplus.module.movies;

import com.cicinnus.corelib.base.ICoreLoadingView;
import com.cicinnus.doubanplus.module.movies.bean.ComingMovieBean;
import com.cicinnus.doubanplus.module.movies.bean.InTheaterMoviesBean;

import java.util.List;

/**
 * @author Cicinnus
 *         on 2017/11/21.
 */

public class IMoviesContract {
    interface ITheaterMoviesView extends ICoreLoadingView{
        void addTheaterMovies(List<InTheaterMoviesBean.SubjectsBean> subjects);

        void addMoreTheaterMovies(List<InTheaterMoviesBean.SubjectsBean> subjects);

        void loadMoreFail(String s);

        void addComingMovies(List<ComingMovieBean.SubjectsBean> subjects);

        void addMoreComingMovies(List<ComingMovieBean.SubjectsBean> subjects);
    }

    interface IMoviesPresenter {
        void getTheaterMovies(int start);

        void getComingMovies(int start);


    }
}
