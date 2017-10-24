package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.activities.ProfileActivity;
import com.mikepenz.fastadapter.items.AbstractItem;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tetawex on 31.05.2017.
 */

public class LectureItem extends AbstractItem<LectureItem, LectureItem.ViewHolder> {
    private static final String DATE_FORMAT = "hh:mm";
    private static final DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(DATE_FORMAT);

    private Integer id;
    private String imageUrl;
    private String name;
    private String description;
    private Integer speakerId;
    private String speakerName;
    private DateTime dateTimeStart;
    private DateTime dateTimeEnd;

    public LectureItem() {
    }


    @Override
    public LectureItem.ViewHolder getViewHolder(View v) {
        return new LectureItem.ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.file_item_id;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycleritem_lecture;
    }

    @Override
    public void bindView(LectureItem.ViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);
        Context context = holder.view.getContext();
        holder.tvSpeakerName.setText(speakerName);
        holder.tvLectureName.setText(name);
        holder.tvLectureDescription.setText(description);
        holder.tvTimeRange.setText(dateTimeStart.toString(dateFormatter) + " - " + dateTimeEnd.toString(dateFormatter));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(ProfileActivity.KEY_ID, speakerId);
                bundle.putBoolean(ProfileActivity.KEY_HOME_AS_UP_ENABLED, true);
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        Glide
                .with(context)
                .load(imageUrl)
                .asBitmap().centerCrop()
                .placeholder(R.drawable.shape_cirrcle_grey)
                .into(new BitmapImageViewTarget(holder.ivLectureImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        holder.ivLectureImage.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    @Override
    public void unbindView(LectureItem.ViewHolder holder) {
        super.unbindView(holder);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_lecture_time_range)
        TextView tvTimeRange;

        @BindView(R.id.tv_lecture_name)
        TextView tvLectureName;

        @BindView(R.id.tv_speaker_name)
        TextView tvSpeakerName;

        @BindView(R.id.tv_lecture_description)
        TextView tvLectureDescription;

        @BindView(R.id.iv_lecture_image)
        ImageView ivLectureImage;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public DateTime getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(DateTime dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public DateTime getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(DateTime dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public Integer getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Integer speakerId) {
        this.speakerId = speakerId;
    }
}
