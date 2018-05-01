// Generated code from Butter Knife. Do not modify!
package com.bartech.pss.sa.ui.Shift;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bartech.pss.sa.R;
import com.zcw.togglebutton.ToggleButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShiftActivity_ViewBinding implements Unbinder {
  private ShiftActivity target;

  private View view2131230765;

  private View view2131230762;

  @UiThread
  public ShiftActivity_ViewBinding(ShiftActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShiftActivity_ViewBinding(final ShiftActivity target, View source) {
    this.target = target;

    View view;
    target.btnToggleStatic = Utils.findRequiredViewAsType(source, R.id.toggele_static, "field 'btnToggleStatic'", ToggleButton.class);
    target.btnToggle1 = Utils.findRequiredViewAsType(source, R.id.toggele1, "field 'btnToggle1'", ToggleButton.class);
    target.btnToggle2 = Utils.findRequiredViewAsType(source, R.id.toggele2, "field 'btnToggle2'", ToggleButton.class);
    target.btnToggle3 = Utils.findRequiredViewAsType(source, R.id.toggele3, "field 'btnToggle3'", ToggleButton.class);
    target.txtLastCounter1 = Utils.findRequiredViewAsType(source, R.id.txt_last_disp1, "field 'txtLastCounter1'", TextView.class);
    target.txtLastCounter2 = Utils.findRequiredViewAsType(source, R.id.txt_last_disp2, "field 'txtLastCounter2'", TextView.class);
    target.txtLastCounter3 = Utils.findRequiredViewAsType(source, R.id.txt_last_disp3, "field 'txtLastCounter3'", TextView.class);
    target.etEndCounter1 = Utils.findRequiredViewAsType(source, R.id.et_disp1, "field 'etEndCounter1'", EditText.class);
    target.etEndCounter2 = Utils.findRequiredViewAsType(source, R.id.et_disp2, "field 'etEndCounter2'", EditText.class);
    target.etEndCounter3 = Utils.findRequiredViewAsType(source, R.id.et_disp3, "field 'etEndCounter3'", EditText.class);
    target.txtLiters1 = Utils.findRequiredViewAsType(source, R.id.txt_disp1_total, "field 'txtLiters1'", TextView.class);
    target.txtLiters2 = Utils.findRequiredViewAsType(source, R.id.txt_disp2_total, "field 'txtLiters2'", TextView.class);
    target.txtLiters3 = Utils.findRequiredViewAsType(source, R.id.txt_disp3_total, "field 'txtLiters3'", TextView.class);
    target.txtStartShift = Utils.findRequiredViewAsType(source, R.id.txt_start_shift, "field 'txtStartShift'", TextView.class);
    target.txtEndShift = Utils.findRequiredViewAsType(source, R.id.txt_end_shift, "field 'txtEndShift'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_next, "method 'onSaveClicked'");
    view2131230765 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSaveClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_cancel, "method 'onCancelClicked'");
    view2131230762 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCancelClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ShiftActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnToggleStatic = null;
    target.btnToggle1 = null;
    target.btnToggle2 = null;
    target.btnToggle3 = null;
    target.txtLastCounter1 = null;
    target.txtLastCounter2 = null;
    target.txtLastCounter3 = null;
    target.etEndCounter1 = null;
    target.etEndCounter2 = null;
    target.etEndCounter3 = null;
    target.txtLiters1 = null;
    target.txtLiters2 = null;
    target.txtLiters3 = null;
    target.txtStartShift = null;
    target.txtEndShift = null;

    view2131230765.setOnClickListener(null);
    view2131230765 = null;
    view2131230762.setOnClickListener(null);
    view2131230762 = null;
  }
}
