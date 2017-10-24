package com.cyrilmarten.conf.conpro17mobile.util;

import java.util.concurrent.TimeUnit;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bulgakov on 30/04/2017.
 */

public class RxUtils {

	public static <T> ObservableTransformer<T, T> applySchedulers() {
		return tObservable -> tObservable.subscribeOn(Schedulers.io())
										 .observeOn(AndroidSchedulers.mainThread());
	}

	public static <T> ObservableTransformer<T, T> applyOpBeforeAndAfter(
		Runnable before, Runnable after) {
		return tObservable -> tObservable.doOnComplete(after::run).doOnSubscribe(t-> before.run());
	}

	public static <T> ObservableTransformer<T, T> applyOpAfter(Runnable after) {
		return tObservable -> tObservable.doOnComplete(after::run);
	}
	public static <T> ObservableTransformer<T, T> applyShortDelay() {
		return tObservable -> tObservable
				.delay(0, TimeUnit.SECONDS, AndroidSchedulers.mainThread());
	}
}
