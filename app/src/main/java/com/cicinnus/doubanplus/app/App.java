package com.cicinnus.doubanplus.app;

import android.app.Application;
import android.content.Context;

import com.cicinnus.corelib.net.RetrofitClient;
import com.cicinnus.doubanplus.base.Constants;
import com.cicinnus.doubanplus.net.OkHttpManager;


/**
 * @author Cicinnus
 *         on 2017/11/20.
 */

public class App extends Application {


    private static App instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        RetrofitClient.initUrlAndOkHttp(Constants.DOUBAN_URL, OkHttpManager.getInstance());

    }

    public static Context getInstance() {
        return instance;
    }
}
