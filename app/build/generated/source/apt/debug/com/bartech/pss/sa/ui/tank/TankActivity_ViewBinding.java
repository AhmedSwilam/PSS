// Generated code from Butter Knife. Do not modify!
package com.bartech.pss.sa.ui.tank;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bartech.pss.sa.R;
import com.zcw.togglebutton.ToggleButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TankActivity_ViewBinding implements Unbinder {
  private TankActivity target;

  @UiThread
  public TankActivity_ViewBinding(TankActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TankActivity_ViewBinding(TankActivity target, View source) {
    this.target = target;

    target.txtStartShift = Utils.findRequiredViewAsType(source, R.id.txt_start_shift, "field 'txtStartShift'", TextView.class);
    target.txtEndShift = Utils.findRequiredViewAsType(source, R.id.txt_end_shift, "field 'txtEndShift'", TextView.class);
    target.btnToggleStatic = Utils.findRequiredViewAsType(source, R.id.toggele_static, "field 'btnToggleStatic'", ToggleButton.class);
    target.btnToggle1 = Utils.findRequiredViewAsType(source, R.id.toggele1, "field 'btnToggle1'", ToggleButton.class);
    target.btnToggle2 = Utils.findRequiredViewAsType(source, R.id.toggele2, "field 'btnToggle2'", ToggleButton.class);
    target.btnToggle3 = Utils.findRequiredViewAsType(source, R.id.toggele3, "field 'btnToggle3'", ToggleButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TankActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtStartShift = null;
    target.txtEndShift = null;
    target.btnToggleStatic = null;
    target.btnToggle1 = null;
    target.btnToggle2 = null;
    target.btnToggle3 = null;
  }
}
