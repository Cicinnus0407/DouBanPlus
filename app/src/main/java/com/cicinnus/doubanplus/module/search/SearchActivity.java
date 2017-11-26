package com.cicinnus.doubanplus.module.search;

import android.app.SearchManager;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.TransitionRes;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.SlideInBottomAnimation;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.BaseActivity;
import com.cicinnus.doubanplus.module.movies_detail.MovieDetailActivity;
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
    @BindView(R.id.container)
    FrameLayout container;


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
        setupTransitions();

        initRv();
    }


    /**
     * 初始化Rv
     */
    private void initRv() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        rvSearchResult.setLayoutManager(linearLayoutManager);
        rvSearchResult.setHasFixedSize(true);

        searchMoviesAdapter = new SearchMoviesAdapter();

        searchMoviesAdapter.setOnMovieItemClickListener(new SearchMoviesAdapter.OnMovieItemClickListener() {
            @Override
            public void onClick(View view, SearchResultBean.SubjectsBean bean) {
                Intent intent = new Intent();
                intent.setClass(mContext, MovieDetailActivity.class);
                intent.putExtra("id", bean.getId());

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mContext,
                        Pair.create(view, mContext.getString(R.string.transition_movie_img)));
                startActivity(intent, options.toBundle());
            }
        });

        rvSearchResult.setAdapter(searchMoviesAdapter);
        //加载更多的动画
        searchMoviesAdapter.openLoadAnimation(new SlideInBottomAnimation());
        searchMoviesAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.searchMovies(keyword, start);
            }
        }, rvSearchResult);


    }


    /**
     * 设置进入的揭露动画
     */
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

    private SparseArray<Transition> transitions = new SparseArray<>();

    private Transition getTransition(@TransitionRes int transitionId) {
        Transition transition = transitions.get(transitionId);
        if (transition == null) {
            transition = TransitionInflater.from(mContext).inflateTransition(transitionId);
            transitions.put(transitionId, transition);
        }
        return transition;
    }

    /**
     * 点解半透明view和搜索按钮关闭activity
     */
    @OnClick({R.id.scrim, R.id.searchback})
    protected void dismiss() {
        searchBack.setBackground(null);
        finishAfterTransition();
    }


    /**
     * 搜索
     *
     * @param query
     */
    private void searchFor(String query) {
        keyword = query;
        start = 0;
        KeyBoardUtils.hideIme(searchView);
        searchView.clearFocus();
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
