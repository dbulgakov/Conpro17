package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.activities.ConferenceActivity;
import com.mikepenz.fastadapter.items.AbstractItem;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bulgakov on 06/05/2017.
 * Last updated 16:36 06/05/2017 by bulgakov
 */

public class ConferenceItem extends AbstractItem<ConferenceItem, ConferenceItem.ViewHolder> {
	private static final String DATE_FORMAT = "EEEE, d MMMM";
	private static final DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(DATE_FORMAT);

	private int id;
	private String title;
	private String description;
	private String imageUrl;
	private String location;
	private DateTime dateTime;

	public ConferenceItem() {
	}

	public ConferenceItem(int id, String title,
						  String description, String imageUrl,
						  String location,DateTime dateTime) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
		this.location = location;
		this.dateTime = dateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}


    @Override
	public ViewHolder getViewHolder(View v) {
		return new ViewHolder(v);
	}

	@Override
	public int getType() {
		return R.id.conference_feed_item_id;
	}

	@Override
	public int getLayoutRes() {
		return R.layout.recycleritem_card_event;
	}

	@Override
	public void bindView(ViewHolder holder, List<Object> payloads) {
		super.bindView(holder, payloads);
		Context context = holder.view.getContext();

		holder.tvDate.setText(dateTime.toString(dateFormatter));
		holder.tvLocation.setText(location);
		holder.tvConferenceTitle.setText(title);
		holder.tvConferenceDescription.setText(description);
		holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: refactor asap!
                Bundle bundle=new Bundle();

                bundle.putInt(ConferenceActivity.KEY_ID, id);
                bundle.putBoolean(ConferenceActivity.KEY_HOME_AS_UP_ENABLED,true);
                bundle.putString(ConferenceActivity.KEY_NAME,
                        holder.tvConferenceTitle.getText().toString());

                Intent intent=new Intent(context,ConferenceActivity.class);
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });
		Glide
			.with(context)
			.load(imageUrl)
			.placeholder(R.color.colorDefaultBackground)
			.listener(new RequestListener<String, GlideDrawable>() {
				@Override
				public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
					holder.ivConferenceLogoProgressbar.setVisibility(View.GONE);
					return false;
				}

				@Override
				public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
					holder.ivConferenceLogoProgressbar.setVisibility(View.GONE);
					return false;
				}
			})
			.into(holder.ivConferenceLogo);
	}

	@Override
	public void unbindView(ViewHolder holder) {
		super.unbindView(holder);
	}

	static class ViewHolder extends RecyclerView.ViewHolder {

		@BindView(R.id.tv_date)
		TextView tvDate;

		@BindView(R.id.tv_location)
		TextView tvLocation;

		@BindView(R.id.tv_conference_title)
		TextView tvConferenceTitle;

		@BindView(R.id.iv_conference_logo)
		ImageView ivConferenceLogo;

		@BindView(R.id.tv_conference_description)
		TextView tvConferenceDescription;

		@BindView(R.id.iv_conference_logo_progressbar)
		ProgressBar ivConferenceLogoProgressbar;

		protected View view;

		public ViewHolder(View view) {
			super(view);
			ButterKnife.bind(this, view);
			this.view = view;
		}
	}
}
