package com.cyrilmarten.conf.conpro17mobile.util.TextTools;

import android.view.View;
import android.widget.EditText;

/**
 * Created by bulgakov on 02/05/2017.
 */

public class EditTextOnFocusChangeListener implements View.OnFocusChangeListener{

	@EditTextChecker.EditTextInputType
	final int editTextInputType;

	public EditTextOnFocusChangeListener(@EditTextChecker.EditTextInputType int editTextInputType) {
		this.editTextInputType = editTextInputType;
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		if (v instanceof EditText) {
			if (!hasFocus) {
				EditTextChecker.checkEditTextInputValid((EditText) v, editTextInputType);
			}
		} else {
			throw new IllegalArgumentException("Only EditText instances are supported");
		}
	}
}
