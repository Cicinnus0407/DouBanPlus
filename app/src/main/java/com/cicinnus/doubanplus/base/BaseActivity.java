package com.cicinnus.doubanplus.base;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.cicinnus.corelib.base.BaseMvpActivity;
import com.cicinnus.corelib.base.ICorePresenter;
import com.cicinnus.doubanplus.R;



/**
 *
 */

public abstract class BaseActivity<T extends ICorePresenter> extends BaseMvpActivity<T> {



    @Override
    public int getLayout() {
        return getLayoutId();
    }


    protected abstract int getLayoutId();


    @Override
    protected void initEventAndData() {
    }


    protected void setUpToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    protected void setupSwipe(SwipeRefreshLayout swipe, SwipeRefreshLayout.OnRefreshListener listener) {
        swipe.setColorSchemeResources(R.color.colorPrimary);
        swipe.setOnRefreshListener(listener);
    }

}
