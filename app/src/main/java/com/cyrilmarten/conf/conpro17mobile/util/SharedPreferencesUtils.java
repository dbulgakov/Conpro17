package com.cyrilmarten.conf.conpro17mobile.util;

import android.content.SharedPreferences;

import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by bulgakov on 01/05/2017.
 */

public class SharedPreferencesUtils {

	public static final String PREFERENCES_KEY = "com.cyrilmarten.conf.conpro17mobile";
	public static final String APP_FIRST_RUN_KEY = "APP_FIRST_RUN_KEY";

	public static boolean checkIfFirstRun() {
		return getSharedPreferences().getBoolean(APP_FIRST_RUN_KEY, true);
	}

	public static void setFirstRunCompleted() {
		getSharedPreferences().edit().putBoolean(APP_FIRST_RUN_KEY, false).apply();
	}


	private static SharedPreferences getSharedPreferences() {
		return App.getContext().getSharedPreferences(PREFERENCES_KEY, MODE_PRIVATE);
	}
}
