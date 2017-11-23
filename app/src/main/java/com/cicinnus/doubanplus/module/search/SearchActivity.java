package com.cicinnus.doubanplus.module.search;

import android.app.SearchManager;
import android.app.SharedElementCallback;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.cicinnus.doubanplus.utils.ToastUtil;
import com.cicinnus.doubanplus.utils.TransitionUtils;
import com.cicinnus.doubanplus.view.ProgressLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Cicinnus
 *         on 2017/11/23.
 *         搜索Activity
 */

public class SearchActivity extends BaseActivity<SearchMoviesPresenter> implements SearchMovieContract.ISearchMoviesView {


    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.searchback)
    ImageButton searchBack;
    @BindView(R.id.progress_layout)
    ProgressLayout progressLayout;
    @BindView(R.id.search_results)
    RecyclerView rvSearchResult;


    private SearchMoviesAdapter searchMoviesAdapter;
    private int start = 0;
    private String keyword = "";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected SearchMoviesPresenter getCorePresenter() {
        return new SearchMoviesPresenter(mContext, this);
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
        rvSearchResult.setLayoutManager(new LinearLayoutManager(mContext));
        searchMoviesAdapter = new SearchMoviesAdapter();
        rvSearchResult.setAdapter(searchMoviesAdapter);
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
        keyword = query;
        start = 0;
        mPresenter.searchMovies(keyword, start);

    }

    /**
     * 清空搜索内容
     */
    private void clearResults() {
        searchMoviesAdapter.getData().clear();
        searchMoviesAdapter.notifyDataSetChanged();
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

    @Override
    public void showLoading() {
        progressLayout.showLoading();
    }

    @Override
    public void showContent() {
        if (!progressLayout.isContent()) {
            progressLayout.showContent();
        }
    }

    @Override
    public void showError(String errorMsg) {
        ToastUtil.showToast(errorMsg);
        progressLayout.showError(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.searchMovies(keyword, start);
            }
        });
    }

    @Override
    public void addMoreSearchResult(List<SearchResultBean.SubjectsBean> subjects) {
        if (subjects.size() > 0) {
            searchMoviesAdapter.addData(subjects);
            searchMoviesAdapter.loadMoreComplete();
            start += 10;
        }
    }

    @Override
    public void addSearchResult(List<SearchResultBean.SubjectsBean> subjects) {
        searchMoviesAdapter.setNewData(subjects);
        start = 10;

    }

    @Override
    public void loadMoreError(String s) {
        ToastUtil.showToast(s);
        searchMoviesAdapter.loadMoreFail();
    }
}
