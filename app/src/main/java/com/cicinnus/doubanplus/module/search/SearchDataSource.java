package com.cicinnus.doubanplus.module.search;

import com.cicinnus.corelib.net.RetrofitClient;
import com.cicinnus.doubanplus.net.Api;

import io.reactivex.Observable;

/**
 * 搜索数据管理
 *
 * Created by Cicinnus
 * on 2017/11/23.
 */

public class SearchDataSource {

    Observable<SearchResultBean> searchMovies(String keyword,int start){
        return RetrofitClient
                .getInstance()
                .create(Api.class)
                .searchMovies(keyword,start,10);
    }


}
