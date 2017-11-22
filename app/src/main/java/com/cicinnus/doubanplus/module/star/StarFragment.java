package com.cicinnus.doubanplus.module.star;

import android.os.Bundle;

import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.BaseFragment;

/**
 * @author Cicinnus
 *         on 2017/11/21.
 */

public class StarFragment extends BaseFragment {

    public static StarFragment newInstance() {

        Bundle args = new Bundle();

        StarFragment fragment = new StarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_star;
    }
}
