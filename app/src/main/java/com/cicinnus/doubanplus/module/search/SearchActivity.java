package com.cicinnus.doubanplus.module.search;

import android.app.SearchManager;
import android.app.SharedElementCallback;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.transition.TransitionSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.BaseActivity;
import com.cicinnus.doubanplus.ui.transitions.CircularReveal;
import com.cicinnus.doubanplus.utils.KeyBoardUtils;
import com.cicinnus.doubanplus.utils.TransitionUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Cicinnus
 *         on 2017/11/23.
 *         搜索Activity
 */

public class SearchActivity extends BaseActivity {


    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.searchback)
    ImageButton searchBack;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initEventAndData() {
        setupSearchView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupTransitions();
        }

        initRv();
    }

    private void initRv() {
    }


    /**
     * 设置进入的揭露动画
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupTransitions() {
        setEnterSharedElementCallback(new SharedElementCallback() {
            @Override
            public void onSharedElementStart(
                    List<String> sharedElementNames,
                    List<View> sharedElements,
                    List<View> sharedElementSnapshots) {
                if (sharedElements != null && !sharedElements.isEmpty()) {
                    View searchIcon = sharedElements.get(0);
                    if (searchIcon.getId() != R.id.searchback) return;
                    int centerX = (searchIcon.getLeft() + searchIcon.getRight()) / 2;
                    CircularReveal hideResults = (CircularReveal) TransitionUtils.findTransition(
                            (TransitionSet) getWindow().getReturnTransition(),
                            CircularReveal.class, R.id.results_container);
                    if (hideResults != null) {
                        hideResults.setCenter(new Point(centerX, 0));
                    }
                }
            }
        });
    }


    /**
     * 初始化SearchView
     */
    private void setupSearchView() {
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setQueryHint(getString(R.string.search_hint));
        searchView.setImeOptions(searchView.getImeOptions() | EditorInfo.IME_ACTION_SEARCH |
                EditorInfo.IME_FLAG_NO_EXTRACT_UI | EditorInfo.IME_FLAG_NO_FULLSCREEN);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchFor(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                if (TextUtils.isEmpty(query)) {
                    clearResults();
                }
                return true;
            }
        });
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
    }

    @OnClick({R.id.scrim, R.id.searchback})
    protected void dismiss() {
        searchBack.setBackground(null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            onBackPressed();
        }
    }


    /**
     * 搜索
     *
     * @param query
     */
    private void searchFor(String query) {

    }

    /**
     * 清空搜索内容
     */
    private void clearResults() {

    }


    @Override
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }


    @Override
    public void onEnterAnimationComplete() {
        searchView.requestFocus();
        KeyBoardUtils.showKeyBoard(searchView);
    }
}
