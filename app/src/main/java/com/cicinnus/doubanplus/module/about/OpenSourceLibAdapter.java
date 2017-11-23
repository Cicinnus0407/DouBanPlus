package com.cicinnus.doubanplus.module.about;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cicinnus.doubanplus.R;

import java.util.List;

/**
 * @author Cicinnus
 *         on 2017/11/23.
 *         开源项目列表adapter
 */

class OpenSourceLibAdapter extends BaseQuickAdapter<AboutActivity.OpenSourceLib, BaseViewHolder> {


    public OpenSourceLibAdapter(List<AboutActivity.OpenSourceLib> data) {
        super(R.layout.item_open_source_lib, data);
    }


    @Override
    protected void convert(final BaseViewHolder baseViewHolder, final AboutActivity.OpenSourceLib openSourceLib) {
            baseViewHolder.setText(R.id.library_name, openSourceLib.getName())
                    .setText(R.id.library_description, openSourceLib.getDescription());
        System.out.println(baseViewHolder);
        ImageView view = baseViewHolder.getView(R.id.iv_library_image);
        Glide.with(view.getContext()).load(openSourceLib.getImageUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view);

        baseViewHolder.getView(R.id.library_link).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseViewHolder.itemView.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(openSourceLib.getLink())));

            }
        });
    }
}

