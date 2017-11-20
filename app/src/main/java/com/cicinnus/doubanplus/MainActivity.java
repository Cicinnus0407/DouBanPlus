package com.cicinnus.doubanplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cicinnus.corelib.net.RetrofitClient;
import com.cicinnus.corelib.rx.SchedulersCompact;
import com.cicinnus.doubanplus.net.Api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitClient
                .getInstance()
                .create(Api.class)
                .getMovieInTheaters(null)
                .compose(SchedulersCompact.<ResponseBody>applyIoSchedulers())
                .subscribe(new DefaultObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
