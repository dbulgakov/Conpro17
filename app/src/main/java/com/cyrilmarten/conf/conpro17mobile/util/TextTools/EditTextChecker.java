package com.cyrilmarten.conf.conpro17mobile.util.TextTools;

import android.support.annotation.IntDef;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.cyrilmarten.conf.conpro17mobile.util.TextTools.EditTextChecker.EditTextInputType.EMAIL;
import static com.cyrilmarten.conf.conpro17mobile.util.TextTools.EditTextChecker.EditTextInputType.PASSWORD;
import static com.cyrilmarten.conf.conpro17mobile.util.TextTools.EditTextChecker.EditTextInputType.PHONE;
import static com.cyrilmarten.conf.conpro17mobile.util.TextTools.EditTextChecker.EditTextInputType.TEXT;

/**
 * Created by bulgakov on 02/05/2017.
 */

public class EditTextChecker {

	public static final int MIN_PASSWORD_LENGTH = 6;
	@IntDef({EMAIL, PASSWORD, TEXT, PHONE})
	@Retention(RetentionPolicy.SOURCE)
	public @interface EditTextInputType {
		int EMAIL = 0;
		int PASSWORD = 1;
		int TEXT = 2;
		int PHONE = 3;
	}

	public static boolean checkEditTextInputValid(EditText editText, @EditTextInputType int inputType) {
		if (editText != null) {
			CharSequence text = editText.getText();
			switch (inputType) {
				case EMAIL:
					return checkEditTextInputValid(editText, android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches(), R.string.error_msg_wrong_email_input);
				case PASSWORD:
					return checkEditTextInputValid(editText, text.length() >= MIN_PASSWORD_LENGTH, R.string.error_msg_wrong_password_input);
				case TEXT:
					return checkEditTextInputValid(editText, true, R.string.error_msg_wrong_text_input);
				case PHONE:
					return checkEditTextInputValid(editText, Patterns.PHONE.matcher(text).matches(), R.string.error_msg_wrong_phone_input);
			}
		}

		throw new IllegalArgumentException("Input EditText must not be null");
	}

	public static boolean checkEditTextInputValid(EditText editText, boolean checkResult, int errorMessageResId) {
		CharSequence text = editText.getText();
		if (TextUtils.isEmpty(text) || !checkResult) {
			editText.setError(App.getContext().getString(errorMessageResId));
			return false;
		}
		return true;
	}
}
