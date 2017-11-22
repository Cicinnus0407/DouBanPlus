package com.cicinnus.doubanplus.module.movies;

import com.cicinnus.corelib.net.RetrofitClient;
import com.cicinnus.doubanplus.module.movies.bean.ComingMovieBean;
import com.cicinnus.doubanplus.module.movies.bean.InTheaterMoviesBean;
import com.cicinnus.doubanplus.net.Api;

import io.reactivex.Observable;

/**
 * @author Cicinnus
 *         on 2017/11/21.
 *         数据管理
 */

public class InTheaterMoviesDataSource {


    /**
     * 联网获取热映电影
     *
     * @param start
     * @return
     */
    Observable<InTheaterMoviesBean> getInTheaterMovies(int start) {
        return RetrofitClient.getInstance().create(Api.class)
                .getMovieInTheaters(start, 10, "");
    }

    Observable<ComingMovieBean> getComingMovies(int start) {
        return RetrofitClient
                .getInstance().create(Api.class)
                .getComingMovies(start, 10);
    }
}
