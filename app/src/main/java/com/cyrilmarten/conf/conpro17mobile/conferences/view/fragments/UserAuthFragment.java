package com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.UserAuthPresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.UserAuthView;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.activities.UserAuthActivity;
import com.cyrilmarten.conf.conpro17mobile.core.view.fragments.BaseFragment;
import com.cyrilmarten.conf.conpro17mobile.util.SharedPreferencesUtils;
import com.cyrilmarten.conf.conpro17mobile.util.TextTools.EditTextChecker;
import com.cyrilmarten.conf.conpro17mobile.util.TextTools.EditTextOnFocusChangeListener;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;

import static com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.UserAuthFragment.UserAuthFragmentType.INTRO;
import static com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.UserAuthFragment.UserAuthFragmentType.LOGIN;
import static com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.UserAuthFragment.UserAuthFragmentType.REGISTRATION;

/**
 * Created by bulgakov on 30/04/2017.
 */

public class UserAuthFragment extends BaseFragment<UserAuthView> implements UserAuthView{

	private static final String USER_AUTH_FRAGMENT_TYPE = "user_auth_fragment_type";

	private int fragmentType;

	@Inject
	UserAuthPresenter userAuthPresenter;

	@BindView(R.id.et_user_name)
	@Nullable
	EditText etUserName;

	@BindView(R.id.et_user_email)
	@Nullable
	EditText etUserEmail;

	@BindView(R.id.et_user_password)
	@Nullable
	EditText etUserPassword;

	@BindView(R.id.et_user_password_2)
	@Nullable
	EditText etUserPassword2;

	public static UserAuthFragment newInstance(@UserAuthFragmentType int fragmentType) {
		Bundle bundle = new Bundle();
		bundle.putInt(USER_AUTH_FRAGMENT_TYPE, fragmentType);
		UserAuthFragment userAuthFragment = new UserAuthFragment();
		userAuthFragment.setArguments(bundle);
		return userAuthFragment;
	}

	public UserAuthFragment() {
		App.getComponent().inject(this);
		setPresenter(userAuthPresenter);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initFragment(getArguments());
	}

	@Optional
	@Override
	@OnClick(R.id.go_login_button)
	public void navigateToLoginFragment() {
		((UserAuthActivity) getActivity()).moveToPage(LOGIN);
	}

	@Optional
	@Override
	@OnClick(R.id.go_register_button)
	public void navigateToRegisterFragment() {((UserAuthActivity) getActivity()).moveToPage(REGISTRATION);
	}

	@Optional
	@OnClick(R.id.button_login)
	public void performUserAuth() {
		if (EditTextChecker.checkEditTextInputValid(etUserEmail, EditTextChecker.EditTextInputType.PASSWORD) && EditTextChecker.checkEditTextInputValid(etUserPassword, EditTextChecker.EditTextInputType.PASSWORD)) {
			userAuthPresenter.performAuth(etUserEmail.getText().toString(), etUserPassword.getText().toString());
		} else {
			showToast(R.string.error_msg_wrong_input);
		}
	}

	@Override
	public void navigateToMainActivity(Bundle userInfoBundle) {
		SharedPreferencesUtils.setFirstRunCompleted();
		UserAuthActivity userAuthActivity = (UserAuthActivity) getActivity();
		userAuthActivity.setAccountAuthenticatorResult(userInfoBundle);
		userAuthActivity.setResult(Activity.RESULT_OK);
		userAuthActivity.finish();
	}

	@Override
	protected void setupViews(View view) {
		super.setupViews(view);
		swipeRefreshLayout.setEnabled(false);
		initTextViews();
	}

	@Override
	public void loadData() {
		// nothing is done here
	}

	@Override
	protected int getContentResId() {
		switch (fragmentType) {
			case REGISTRATION:
				return R.layout.fragment_registration;
			case INTRO:
				return R.layout.fragment_intro;
			case LOGIN:
				return R.layout.fragment_login;
			default:
				return 0;
		}
	}

	@IntDef({REGISTRATION, INTRO, LOGIN})
	@Retention(RetentionPolicy.SOURCE)
	public @interface UserAuthFragmentType {
		int REGISTRATION = 0;
		int INTRO = 1;
		int LOGIN = 2;
	}

	private void initTextViews() {
		switch (fragmentType) {
			case REGISTRATION:
				assert etUserName != null;
				etUserName.setOnFocusChangeListener(new EditTextOnFocusChangeListener(EditTextChecker.EditTextInputType.TEXT));

				assert etUserPassword2 != null;
				assert etUserPassword != null;
				etUserPassword2.setOnFocusChangeListener((v, hasFocus) -> {
					if (!hasFocus) {
						EditTextChecker.checkEditTextInputValid(etUserPassword, etUserPassword.getText().equals(etUserPassword2), R.string.error_msg_wrong_password2_input);
					}
				});

				// no brake - initializing like on login too

			case LOGIN:
				assert etUserEmail != null;
				etUserEmail.setOnFocusChangeListener(new EditTextOnFocusChangeListener(EditTextChecker.EditTextInputType.EMAIL));

				assert etUserPassword != null;
				etUserPassword.setOnFocusChangeListener(new EditTextOnFocusChangeListener(EditTextChecker.EditTextInputType.PASSWORD));
				break;
		}
	}

	private void initFragment(Bundle bundle) {
		if (bundle != null) {
			fragmentType = bundle.getInt(USER_AUTH_FRAGMENT_TYPE);
		} else {
			throw new IllegalStateException("Fragment type must be passed!");
		}
	}
}
