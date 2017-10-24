package com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers;

import android.util.Log;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceFeedItem;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ConferenceItem;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulgakov on 06/05/2017.
 * Last updated 16:55 06/05/2017 by bulgakov
 */

public class ConferenceFeedItemMapper {

	public List<ConferenceItem> map(List<ConferenceFeedItem> conferenceFeedItems) {
		List<ConferenceItem> conferenceItems = new ArrayList<>();
		if (conferenceFeedItems != null) {
			for (ConferenceFeedItem conferenceFeedItem : conferenceFeedItems) {
				conferenceItems.add(map(conferenceFeedItem));
			}
		}
		return conferenceItems;
	}

	public ConferenceItem map(ConferenceFeedItem conferenceFeedItem) {
		Log.e("dwd",conferenceFeedItem.getDescription());
		ConferenceItem conferenceItem = new ConferenceItem();
		if (conferenceFeedItem != null) {
			conferenceItem.setId(conferenceFeedItem.getId());
			conferenceItem.setTitle(conferenceFeedItem.getTitle());
			conferenceItem.setDescription(conferenceFeedItem.getDescription());
			conferenceItem.setImageUrl(conferenceFeedItem.getImageUrl());
			conferenceItem.setLocation(conferenceFeedItem.getLocation());
			conferenceItem.setDateTime(new DateTime(conferenceFeedItem.getDateTime()));
		}
		return conferenceItem;
	}
}
