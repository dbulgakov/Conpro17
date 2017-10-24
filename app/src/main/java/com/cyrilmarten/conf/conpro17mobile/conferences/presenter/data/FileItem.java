package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tetawex on 31.05.2017.
 */

public class FileItem extends AbstractItem<FileItem, FileItem.ViewHolder> {
    private Integer id;
    private String name;
    private String description;
    private String url;

    public FileItem() {
    }

    public FileItem(int id, String name, String url) {
        this.id = id;
        this.name=name;
        this.url=url;
    }

    @Override
    public FileItem.ViewHolder getViewHolder(View v) {
        return new FileItem.ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.file_item_id;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycleritem_file;
    }

    @Override
    public void bindView(FileItem.ViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);
        Context context = holder.view.getContext();
        holder.tvFileDescription.setText(description);
        holder.tvFileName.setText(name);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: refactor asap!
                Uri uri = Uri.parse(url);
                Intent intent  = new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void unbindView(FileItem.ViewHolder holder) {
        super.unbindView(holder);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_file_name)
        TextView tvFileName;

        @BindView(R.id.tv_file_description)
        TextView tvFileDescription;

        protected View view;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.view = view;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
