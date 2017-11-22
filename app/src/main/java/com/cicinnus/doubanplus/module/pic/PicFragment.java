package com.cicinnus.doubanplus.module.pic;

import android.os.Bundle;

import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.BaseFragment;

/**
 * @author Cicinnus
 *         on 2017/11/21.
 */

public class PicFragment extends BaseFragment {


    public static PicFragment newInstance() {

        Bundle args = new Bundle();

        PicFragment fragment = new PicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_pic;
    }
}
