package com.cicinnus.corelib.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * Rv设置数据
 */

public class RvBindings {

    @SuppressWarnings("unchecked")
    @BindingAdapter({"items"})
    public static <T> void setItems(RecyclerView rv, List<T> newData) {
        ((BaseDataBindingAdapter) rv.getAdapter()).setNewData(newData);
    }
    public static void setLayoutManager(){

    }
}
