package com.cicinnus.doubanplus.module.about;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cicinnus.doubanplus.R;
import com.cicinnus.doubanplus.base.BaseActivity;

import java.security.InvalidParameterException;
import java.util.Arrays;

import butterknife.BindView;

/**
 * @author Cicinnnus
 *         on 2017/11/22.
 *         关于页面
 */

public class AboutActivity extends BaseActivity {

    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initEventAndData() {
        setUpToolbar(toolbar, "");
        pager.setAdapter(new AboutPagerAdapter(mContext));
    }


    private class AboutPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;
        private View aboutView;
        private View aboutIcon;
        private View aboutList;


        private OpenSourceLib[] libs = new OpenSourceLib[]{
                new OpenSourceLib("Glide", "An image loading and caching library for Android focused on smooth scrolling.", "https://github.com/bumptech/glide", "https://avatars.githubusercontent.com/u/423539"),
                new OpenSourceLib("OkHttp", "An HTTP & HTTP/2 client for Android and Java applications.", "http://square.github.io/okhttp/", "https://avatars.githubusercontent.com/u/82592"),
                new OpenSourceLib("Retrofit", "A type-safe HTTP client for Android and Java.", "http://square.github.io/retrofit/", "https://avatars.githubusercontent.com/u/82592")
        };


        AboutPagerAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View layout = getPage(position, container);
            container.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        private View getPage(int position, ViewGroup parent) {
            switch (position) {
                case 0:
                    if (aboutView == null) {
                        aboutView = layoutInflater.inflate(R.layout.layout_about_douban_jiang, parent, false);

                    }
                    return aboutView;
                case 1:
                    if (aboutIcon == null) {
                        aboutIcon = layoutInflater.inflate(R.layout.layout_about_icon, parent, false);
                    }
                    return aboutIcon;
                case 2:
                    if (aboutList == null) {
                        aboutList = layoutInflater.inflate(R.layout.layout_about_libs, parent, false);
                        RecyclerView libsList = aboutList.findViewById(R.id.rv_libs);
                        libsList.setLayoutManager(new LinearLayoutManager(mContext));
                        libsList.setAdapter(new OpenSourceLibAdapter(Arrays.asList(libs)));
                    }
                    return aboutList;
            }
            throw new InvalidParameterException();

        }

    }


    class OpenSourceLib {
        private String name;
        private String description;
        private String link;
        private String imageUrl;

        public OpenSourceLib(String name, String description, String link, String imageUrl) {
            this.name = name;
            this.description = description;
            this.link = link;
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getLink() {
            return link;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }


}
