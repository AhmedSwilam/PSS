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
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131230834;

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
    view = Utils.findRequiredView(source, R.id.imageView, "field 'imglogin' and method 'onServerLoginClick'");
    target.imglogin = Utils.castView(view, R.id.imageView, "field 'imglogin'", ImageView.class);
    view2131230834 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onServerLoginClick(p0);
      }
    });
    target.imgForgot = Utils.findRequiredViewAsType(source, R.id.btn_forgot, "field 'imgForgot'", Button.class);
    target.imgGetSupport = Utils.findRequiredViewAsType(source, R.id.img_getsupport, "field 'imgGetSupport'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUserNameEditText = null;
    target.mPasswordEditText = null;
    target.imglogin = null;
    target.imgForgot = null;
    target.imgGetSupport = null;

    view2131230834.setOnClickListener(null);
    view2131230834 = null;
  }
}
