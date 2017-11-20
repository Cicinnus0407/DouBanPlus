package com.cicinnus.doubanplus.net;

import android.support.annotation.Nullable;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Cicinnus
 * on 2017/11/20.
 */

public interface Api {

    //获取正在上映的电音
    @GET("movie/in_theaters")
    Observable<ResponseBody> getMovieInTheaters(@Nullable @Query("city") String cityName);
}
