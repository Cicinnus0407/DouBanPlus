package com.cicinnus.doubanplus.module.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cicinnus.doubanplus.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cicinnus
 *         on 2017/11/21.
 */

public class FilterMenuAdapter extends BaseAdapter {

    private List<FilterMenuBean> beans = new FilterMenuBean().getFilterList();


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int i) {
        return beans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_filter_menu, null);
            holder = new Holder();
            holder.textView = view.findViewById(R.id.tv_filter_name);
            holder.iv = view.findViewById(R.id.iv_filter_icon);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();

        }
        holder.textView.setText(beans.get(i).name);
        Glide.with(view.getContext()).load(beans.get(i).icon).into(holder.iv);
        return view;
    }

    private class Holder {
        private TextView textView;
        private ImageView iv;
    }

    private class FilterMenuBean {
        private String name;
        private int icon;

        public FilterMenuBean() {
        }

        private FilterMenuBean(String name, int icon) {
            this.name = name;
            this.icon = icon;
        }

        public List<FilterMenuBean> getFilterList() {
            List<FilterMenuBean> list = new ArrayList<>();
            list.add(new FilterMenuBean("正在热映", R.drawable.ic_in_theater_orange_24dp));
            list.add(new FilterMenuBean("即将上映", R.drawable.ic_coming_orange_24dp));
            list.add(new FilterMenuBean("新片榜", R.drawable.ic_new_orange_24dp));
            list.add(new FilterMenuBean("口碑榜", R.drawable.ic_good_orange_24dp));
            return list;
        }
    }
}
