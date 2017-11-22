package com.cicinnus.doubanplus.net;

import android.support.annotation.Nullable;

import com.cicinnus.doubanplus.module.movies.bean.ComingMovieBean;
import com.cicinnus.doubanplus.module.movies.bean.InTheaterMoviesBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Cicinnus
 * on 2017/11/20.
 */

public interface Api {

    //正在上映的电影
    @GET("movie/in_theaters")
    Observable<InTheaterMoviesBean> getMovieInTheaters(@Nullable @Query("start") int start, @Query("count") int count, @Nullable @Query("city") String cityName);


    //即将上映的电影
    @GET("movie/coming_soon")
    Observable<ComingMovieBean> getComingMovies(@Query("start") int start, @Query("count") int count);
}
