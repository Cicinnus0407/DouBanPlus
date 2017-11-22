package com.cicinnus.doubanplus.base;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;


import com.cicinnus.corelib.base.BaseMvpFragment;
import com.cicinnus.corelib.base.ICorePresenter;

import java.lang.ref.WeakReference;

/**
 * @author Cicinnus
 *         on 2017/7/31.
 */

public abstract class BaseFragment<T extends ICorePresenter> extends BaseMvpFragment<T> {
    @Override
    protected int getLayoutId() {
        return getLayout();
    }

    protected abstract int getLayout();


    @Override
    protected void initEventAndData() {

    }

}
