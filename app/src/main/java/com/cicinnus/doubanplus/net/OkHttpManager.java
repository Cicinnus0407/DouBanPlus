package com.cicinnus.doubanplus.net;


import com.cicinnus.corelib.BuildConfig;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * 自定义OkHttpClient
 */
public class OkHttpManager {

    public static OkHttpClient getInstance() {
        return InnerClassHolder.okHttpClient;
    }

    private static class InnerClassHolder {

        private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(BuildConfig.DEBUG ? new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) : null)
                //25S连接超时
                .connectTimeout(25, TimeUnit.SECONDS)
                //25s读取超时
                .readTimeout(25, TimeUnit.SECONDS)
                //25s写入超时
                .writeTimeout(25, TimeUnit.SECONDS)
                .build();


    }
}
