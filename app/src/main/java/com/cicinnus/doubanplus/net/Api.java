package com.cicinnus.doubanplus.net;

import android.support.annotation.Nullable;

import com.cicinnus.doubanplus.module.movies.bean.ComingMovieBean;
import com.cicinnus.doubanplus.module.movies.bean.InTheaterMoviesBean;
import com.cicinnus.doubanplus.module.movies_detail.MovieDetailBean;
import com.cicinnus.doubanplus.module.search.SearchResultBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

    //搜索
    @GET("movie/search")
    Observable<SearchResultBean> searchMovies(@Query("q") String keyword, @Query("start") int start, @Query("count") int count);

    //影片详情
    @GET("movie/subject/{movieId}")
    Observable<MovieDetailBean> getMovieDetail(@Path("movieId") String movieId);
}
