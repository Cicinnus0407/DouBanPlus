package com.cicinnus.doubanplus.module.movies;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cicinnus.corelib.utils.UiUtils;
import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.BaseFragment;
import com.cicinnus.doubanplus.databinding.FragmentMoviesBinding;
import com.cicinnus.doubanplus.module.about.AboutActivity;
import com.cicinnus.doubanplus.module.movies.adapter.ComingMovieAdapter;
import com.cicinnus.doubanplus.module.movies.adapter.InTheaterMoviesAdapter;
import com.cicinnus.doubanplus.module.movies.bean.ComingMovieBean;
import com.cicinnus.doubanplus.module.movies.bean.InTheaterMoviesBean;
import com.cicinnus.doubanplus.module.search.SearchActivity;
import com.cicinnus.doubanplus.utils.SnapHelperUtil;
import com.cicinnus.doubanplus.utils.ToastUtil;
import com.cicinnus.doubanplus.view.Banner;
import com.cicinnus.doubanplus.view.ProgressLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 正在上映电影
 *
 * @author cicinnus
 *         on 2017/11/21.
 */

public class MoviesFragment extends BaseFragment<InTheaterMoviesPresenter> implements IMoviesContract.ITheaterMoviesView {


    private FragmentMoviesBinding binding;
    private Toolbar toolbar;
    //状态布局
    private ProgressLayout progressLayout;
    //Rv
    private RecyclerView rvMovies;
    //正在热映adapter
    private InTheaterMoviesAdapter theaterAdapter;
    //待映adapter
    private ComingMovieAdapter comingMovieAdapter;
    //筛选列表
    private ListPopupWindow listPopupWindow;
    //分页
    private int start = 0;
    private AlertDialog dialog;
    private Banner banner;


    /**
     * title的双向绑定
     */
    public static class Title extends BaseObservable {
        public static ObservableField<String> title = new ObservableField<>("热映");
    }

    public static MoviesFragment newInstance() {

        Bundle args = new Bundle();

        MoviesFragment fragment = new MoviesFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_movies;
    }


    @Override
    protected boolean getDataBindingEnable() {
        return true;
    }

    @Override
    protected InTheaterMoviesPresenter getCorePresenter() {
        return new InTheaterMoviesPresenter(mContext, this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Fragment设置toolbar
        setHasOptionsMenu(true);
    }

    @Override
    protected void initEventAndData() {

        binding = (FragmentMoviesBinding) dataBinding;
        initView();
        //Fragment设置toolbar
        toolbar.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        initRv();

        //获取数据
        mPresenter.getTheaterMovies(start);
    }


    /**
     * 初始化RecyclerView
     */
    private void initRv() {
        rvMovies = binding.rvInTheaterMovies;
        //横向单页滑动
        SnapHelperUtil snapHelperUtil = new SnapHelperUtil();
        snapHelperUtil.attachToRecyclerView(rvMovies);

    }

    /**
     * 初始化view
     */
    private void initView() {
        toolbar = binding.toolbar;
        progressLayout = binding.progressLayout;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_movies, menu);
    }

    //点击Toolbar的Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_search:
                View searchMenuView = toolbar.findViewById(R.id.menu_search);
                Bundle options = ActivityOptions.makeSceneTransitionAnimation(mContext, searchMenuView,
                        getString(R.string.transition_search_back)).toBundle();
                startActivity(new Intent(mContext, SearchActivity.class), options);
                break;
            case R.id.menu_filter:
                showFilterList();
                break;
            case R.id.menu_about:
                startActivity(new Intent(mContext, AboutActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(mContext).toBundle());
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 显示筛选列表
     */
    private void showFilterList() {

        if (listPopupWindow == null) {

            listPopupWindow = new ListPopupWindow(mContext);
            listPopupWindow.setAdapter(new FilterMenuAdapter());
            //给每个item设置监听事件
            listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    start = 0;
                    if (position == 0) {
                        Title.title.set("热映");
                        mPresenter.getTheaterMovies(start);
                    } else if (position == 1) {
                        Title.title.set("待映");
                        mPresenter.getComingMovies(start);
                    } else if (position == 2) {
                        showDouBanAlert();
                    } else if (position == 3) {
                        showDouBanAlert();
                    }
                    listPopupWindow.dismiss();
                }
            });

            listPopupWindow.setAnchorView(toolbar);
            listPopupWindow.setHorizontalOffset(UiUtils.getDeviceWidth(mContext));
            listPopupWindow.setVerticalOffset(-6);
            listPopupWindow.setWidth(UiUtils.dp2px(mContext, 200));
        }
        if (!listPopupWindow.isShowing()) {
            listPopupWindow.show();
        } else {
            listPopupWindow.dismiss();
        }
    }

    @Override
    public void showLoading() {
        //每次调用showLoading都会触发progressLayout的loading界面
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
                mPresenter.getTheaterMovies(start);

            }
        });
    }

    @Override
    public void addTheaterMovies(List<InTheaterMoviesBean.SubjectsBean> subjects) {
        rvMovies.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        theaterAdapter = new InTheaterMoviesAdapter();
        rvMovies.setAdapter(theaterAdapter);

        theaterAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getTheaterMovies(start);
            }
        }, rvMovies);
        theaterAdapter.setNewData(subjects);
        start = 10;
    }

    @Override
    public void addMoreTheaterMovies(List<InTheaterMoviesBean.SubjectsBean> subjects) {
        if (subjects.size() > 0) {
            start += 10;
            theaterAdapter.addData(subjects);
            theaterAdapter.loadMoreComplete();
        } else {
            theaterAdapter.loadMoreEnd();
        }
    }

    @Override
    public void loadMoreFail(String s) {
        theaterAdapter.loadMoreFail();
    }

    @Override
    public void addComingMovies(List<ComingMovieBean.SubjectsBean> subjects) {

        rvMovies.setLayoutManager(new GridLayoutManager(mContext, 2));
        comingMovieAdapter = new ComingMovieAdapter();
        initHeader(subjects.subList(0, 5));
        rvMovies.setAdapter(comingMovieAdapter);
        comingMovieAdapter.setNewData(subjects);
        comingMovieAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getComingMovies(start);
            }
        }, rvMovies);
        start = 10;
    }

    /**
     * 初始化顶部的Banner
     *
     * @param subjectsBeans
     */
    private void initHeader(List<ComingMovieBean.SubjectsBean> subjectsBeans) {
        List<Banner.PicBean> list = new ArrayList<>();
        for (int i = 0; i < subjectsBeans.size(); i++) {
            list.add(new Banner.PicBean(subjectsBeans.get(i).getImages().getMedium(), i));

        }
        banner = new Banner(mContext);
        banner.setPic(list);
        comingMovieAdapter.addHeaderView(banner);
    }

    @Override
    public void addMoreComingMovies(List<ComingMovieBean.SubjectsBean> subjects) {
        if (subjects.size() > 0) {
            start += 10;
            comingMovieAdapter.addData(subjects);
            comingMovieAdapter.loadMoreComplete();
        } else {
            comingMovieAdapter.loadMoreEnd();
        }
    }

    private void showDouBanAlert() {
        if (dialog == null) {
            dialog = new AlertDialog.Builder(mContext)
                    .setTitle("App需要获得豆瓣爸爸认同才开放该接口")
                    .setMessage("豆瓣原话:\t在运行过一段时间之后，如果这个非商业网站（例如非盈利性质的图书馆，学校，公益组织等）的确出众，且价值观符合Douban，无版权问题，又不和豆瓣电影有正面的商业竞争，可以申请高级权限。开放基本上所有的接口。")
                    .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create();
        }
        dialog.show();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        banner.stopPlay();
    }
}
