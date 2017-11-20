package com.cicinnus.corelib.net.retry;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhongrongguang on 2017/9/29.
 * 网络请求重试
 */

public class RetryHandler implements Function<Observable<? extends Throwable>, Observable<Long>> {
    private static final int INITAL = 1;
    private int maxConnectCount = 1;

    public RetryHandler(int tryCount) {
        maxConnectCount += tryCount;
    }

    @Override
    public Observable<Long> apply(@NonNull Observable<? extends Throwable> observable) throws Exception {
        return observable.zipWith(Observable.range(INITAL, maxConnectCount),new BiFunction<Throwable,Integer,ThrowableWrapper>(){
            @Override
            public ThrowableWrapper apply(@NonNull Throwable throwable, @NonNull Integer integer) throws Exception {
                if (throwable instanceof IOException) {
                    return new ThrowableWrapper(throwable, integer);
                }
                return new ThrowableWrapper(throwable, maxConnectCount);
            }
        }).concatMap(new Function<ThrowableWrapper, ObservableSource<? extends Long>>() {
            @Override
            public ObservableSource<? extends Long> apply(@NonNull ThrowableWrapper throwableWrapper) throws Exception {
                int tryCount = throwableWrapper.getRetryCount();
                if (maxConnectCount==tryCount) {
                    return Observable.error(throwableWrapper.getSourceThrowable());
                }
                return Observable.timer((long) Math.pow(2,tryCount),TimeUnit.SECONDS,Schedulers.single());
            }
        });
    }

    private static class ThrowableWrapper {
        private Throwable sourceThrowable;
        private Integer retryCount;

        public ThrowableWrapper(Throwable sourceThrowable, Integer retryCount) {
            this.sourceThrowable = sourceThrowable;
            this.retryCount = retryCount;
        }

        public Throwable getSourceThrowable() {
            return sourceThrowable;
        }

        public Integer getRetryCount() {
            return retryCount;
        }
    }
}
