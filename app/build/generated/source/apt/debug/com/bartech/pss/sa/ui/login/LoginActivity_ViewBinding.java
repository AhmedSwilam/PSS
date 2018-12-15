// Generated code from Butter Knife. Do not modify!
package com.bartech.pss.sa.ui.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bartech.pss.sa.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131230839;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.mUserNameEditText = Utils.findRequiredViewAsType(source, R.id.et_username, "field 'mUserNameEditText'", EditText.class);
    target.mPasswordEditText = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'mPasswordEditText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.img_sign_in, "field 'imgLogin' and method 'onServerLoginClick'");
    target.imgLogin = Utils.castView(view, R.id.img_sign_in, "field 'imgLogin'", ImageView.class);
    view2131230839 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onServerLoginClick(p0);
      }
    });
    target.imgForgot = Utils.findRequiredViewAsType(source, R.id.btn_forgot, "field 'imgForgot'", Button.class);
    target.imgGetSupport = Utils.findRequiredViewAsType(source, R.id.img_getsupport, "field 'imgGetSupport'", ImageView.class);
    target.spinnerCompany = Utils.findRequiredViewAsType(source, R.id.spinner_company, "field 'spinnerCompany'", SearchableSpinner.class);
    target.spinnerBranch = Utils.findRequiredViewAsType(source, R.id.spinner_branch, "field 'spinnerBranch'", SearchableSpinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUserNameEditText = null;
    target.mPasswordEditText = null;
    target.imgLogin = null;
    target.imgForgot = null;
    target.imgGetSupport = null;
    target.spinnerCompany = null;
    target.spinnerBranch = null;

    view2131230839.setOnClickListener(null);
    view2131230839 = null;
  }
}
