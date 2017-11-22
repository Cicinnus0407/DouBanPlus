package com.cicinnus.doubanplus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.cicinnus.doubanplus.base.BaseActivity;
import com.cicinnus.doubanplus.module.camera.CameraFragment;
import com.cicinnus.doubanplus.module.movies.MoviesFragment;
import com.cicinnus.doubanplus.module.pic.PicFragment;
import com.cicinnus.doubanplus.module.star.StarFragment;

public class MainActivity extends BaseActivity {


    private MoviesFragment moviesFragment;
    private int mCurrentIndex;
    private PicFragment picFragment;
    private CameraFragment cameraFragment;
    private StarFragment starFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initEventAndData() {


    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        initFragment(savedInstanceState);
        initNav();
    }

    private void initNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nv_movies:
                        switchFragment(0);
                        break;
                    case R.id.nv_pic:
                        switchFragment(1);
                        break;
                    case R.id.nv_moments:
                        switchFragment(2);
                        break;
                    case R.id.nv_star:
                        switchFragment(3);
                        break;
                }
                return true;
            }
        });
    }

    private void initFragment(Bundle savedInstanceState) {
        moviesFragment = MoviesFragment.newInstance();
        picFragment = PicFragment.newInstance();
        cameraFragment = CameraFragment.newInstance();
        starFragment = StarFragment.newInstance();
        if (savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fl_container, moviesFragment, "moviesFragment")
                    .add(R.id.fl_container,picFragment, "picFragment")
                    .add(R.id.fl_container,cameraFragment, "cameraFragment")
                    .add(R.id.fl_container,starFragment, "starFragment")
                    .commit();

            switchFragment(mCurrentIndex);

        } else {


            moviesFragment = (MoviesFragment) getSupportFragmentManager().findFragmentByTag("MoviesFragment");
            picFragment = (PicFragment) getSupportFragmentManager().findFragmentByTag("picFragment");
            cameraFragment = (CameraFragment) getSupportFragmentManager().findFragmentByTag("cameraFragment");
            starFragment = (StarFragment) getSupportFragmentManager().findFragmentByTag("starFragment");

            //获取恢复的下标
            mCurrentIndex = savedInstanceState.getInt("index");

            switchFragment(mCurrentIndex);

        }


    }

    private void switchFragment(int mCurrentIndex) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (mCurrentIndex) {
            case 0:
                transaction
                        .show(moviesFragment)
                        .hide(picFragment)
                        .hide(cameraFragment)
                        .hide(starFragment);
                break;
            case 1:
                transaction
                        .show(picFragment)
                        .hide(moviesFragment)
                        .hide(cameraFragment)
                        .hide(starFragment);

                break;
            case 2:
                transaction
                        .show(cameraFragment)
                        .hide(picFragment)
                        .hide(moviesFragment)
                        .hide(starFragment);

                break;
            case 3:
                transaction
                        .show(starFragment)
                        .hide(picFragment)
                        .hide(cameraFragment)
                        .hide(moviesFragment);

                break;
        }
        transaction.commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", mCurrentIndex);

    }

}
