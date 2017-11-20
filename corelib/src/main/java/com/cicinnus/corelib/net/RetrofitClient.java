package com.cicinnus.corelib.net;


import com.cicinnus.corelib.net.rxJava2_adapter.RxJava2CallAdapterFactory;

import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit的主要调用函数
 */

public class RetrofitClient {
    //主机地址
    private static String mBaseUrl;
    //okHttpClient对象
    private static OkHttpClient mOkHttpClient;
    //Retrofit对象
    private final Retrofit retrofit;

    /**
     * 内部构造
     *
     * @param okHttpClient okHttpClient
     * @param baseUrl      baseUrl
     */
    private RetrofitClient(OkHttpClient okHttpClient, String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient != null ? okHttpClient : new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 在Application的onCreate初始化url和自定义的okhttp
     *
     * @param url          主机地址
     * @param okHttpClient null默认使用自带的okHttp
     */
    public static void initUrlAndOkHttp(@NonNull String url, OkHttpClient okHttpClient) {
        mBaseUrl = url;
        mOkHttpClient = okHttpClient;

    }

    /**
     * 获取Retrofit实例
     * @return
     */
    public static RetrofitClient getInstance() {
        if (mBaseUrl == null) {
            throw new RuntimeException("BaseUrl is null ");
        }
        return InnerClassHolder.ioDH;
    }


    /**
     * 静态内部类,单例模式最优实现
     */
    private  static class InnerClassHolder {
        //内部类直接持有外部类对象
        private static RetrofitClient ioDH = new RetrofitClient(mOkHttpClient, mBaseUrl);

    }


    /**
     * 构建请求
     *
     * @param clz 请求接口
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> clz) {
        return retrofit.create(clz);
    }


}
