package com.cicinnus.doubanplus.app;

import android.app.Application;

import com.cicinnus.corelib.net.RetrofitClient;
import com.cicinnus.doubanplus.base.Constants;
import com.cicinnus.doubanplus.net.OkHttpManager;


/**
 * @author zhongrongguang
 *         on 2017/11/20.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient.initUrlAndOkHttp(Constants.DOUBAN_URL, OkHttpManager.getInstance());

    }
}
