package com.cicinnus.doubanplus.module.movies_detail;


import com.cicinnus.corelib.net.RetrofitClient;
import com.cicinnus.doubanplus.net.Api;

import io.reactivex.Observable;

/**
 * @author Cicinnus
 *         on 2017/11/24.
 */

public class MovieDetailDataSource {

     Observable<MovieDetailBean> getMovieDetail(String movieId){
        return RetrofitClient.getInstance().create(Api.class)
                .getMovieDetail(movieId);
    }


}
