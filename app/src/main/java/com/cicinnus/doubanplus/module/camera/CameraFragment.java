package com.cicinnus.doubanplus.module.camera;

import android.os.Bundle;

import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.BaseFragment;

/**
 * @author Cicinnus
 *         on 2017/11/21.
 */

public class CameraFragment extends BaseFragment {


    public static CameraFragment newInstance() {

        Bundle args = new Bundle();

        CameraFragment fragment = new CameraFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_camera;
    }
}
