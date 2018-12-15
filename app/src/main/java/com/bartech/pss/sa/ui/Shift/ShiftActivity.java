package com.bartech.pss.sa.ui.Shift;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.bartech.pss.sa.R;
import com.bartech.pss.sa.data.network.model.LoginResponsePss;
import com.bartech.pss.sa.ui.base.BaseActivity;
import com.bartech.pss.sa.ui.tank.TankActivity;
import com.bartech.pss.sa.utils.AppConstants;
import com.bartech.pss.sa.utils.CommonUtils;
import com.zcw.togglebutton.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bartech.pss.sa.utils.AppConstants.SHAREDPREFERNCE_DISP1;
import static com.bartech.pss.sa.utils.AppConstants.SHAREDPREFERNCE_DISP2;
import static com.bartech.pss.sa.utils.AppConstants.SHAREDPREFERNCE_DISP3;
import static com.bartech.pss.sa.utils.AppConstants.SHAREDPREFERNCE_TOTAL1;
import static com.bartech.pss.sa.utils.AppConstants.SHAREDPREFERNCE_TOTAL2;
import static com.bartech.pss.sa.utils.AppConstants.SHAREDPREFERNCE_TOTAL3;

/**
 * Created by Ahmed on 4/21/2018.
 */

public class ShiftActivity extends BaseActivity implements ShiftMvpView {
    private int valueOfEndCounter = 0;
    private int valueOfEndCounter2 = 0;
    private int valueOfEndCounter3 = 0;
    @BindView(R.id.toggele_static)
    ToggleButton btnToggleStatic;
    @BindView(R.id.toggele1)
    ToggleButton btnToggle1;
    @BindView(R.id.toggele2)
    ToggleButton btnToggle2;
    @BindView(R.id.toggele3)
    ToggleButton btnToggle3;
    @BindView(R.id.txt_last_disp1)
    TextView txtLastCounter1;
    @BindView(R.id.txt_last_disp2)
    TextView txtLastCounter2;
    @BindView(R.id.txt_last_disp3)
    TextView txtLastCounter3;
    @BindView(R.id.et_disp1)
    EditText etEndCounter1;
    @BindView(R.id.et_disp2)
    EditText etEndCounter2;
    @BindView(R.id.et_disp3)
    EditText etEndCounter3;
    @BindView(R.id.txt_disp1_total)
    TextView txtLiters1;
    @BindView(R.id.txt_disp2_total)
    TextView txtLiters2;
    @BindView(R.id.txt_disp3_total)
    TextView txtLiters3;
    @BindView(R.id.txt_start_shift)
    TextView txtStartShift;
    @BindView(R.id.txt_end_shift)
    TextView txtEndShift;

    @Inject
    ShiftMvpPresenter<ShiftMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideKeyboard();
        setContentView(R.layout.shift_activity);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(ShiftActivity.this);

        LoginResponsePss loginResponsePss = CommonUtils.getUser(this);

        setDateAndTime();


        if (!CommonUtils.getPreference(this, SHAREDPREFERNCE_DISP1).equalsIgnoreCase(""))
            txtLastCounter1.setText(CommonUtils.getPreference(this, SHAREDPREFERNCE_DISP1));
        if (!CommonUtils.getPreference(this, SHAREDPREFERNCE_DISP2).equalsIgnoreCase(""))
            txtLastCounter2.setText(CommonUtils.getPreference(this, SHAREDPREFERNCE_DISP2));
        if (!CommonUtils.getPreference(this, SHAREDPREFERNCE_DISP3).equalsIgnoreCase(""))
            txtLastCounter3.setText(CommonUtils.getPreference(this, SHAREDPREFERNCE_DISP2));
        if (!CommonUtils.getPreference(this, SHAREDPREFERNCE_TOTAL1).equalsIgnoreCase(""))
            txtLiters1.setText(CommonUtils.getPreference(this, SHAREDPREFERNCE_TOTAL1));
        if (!CommonUtils.getPreference(this, SHAREDPREFERNCE_TOTAL2).equalsIgnoreCase(""))
            txtLiters2.setText(CommonUtils.getPreference(this, SHAREDPREFERNCE_TOTAL2));
        if (!CommonUtils.getPreference(this, SHAREDPREFERNCE_TOTAL3).equalsIgnoreCase(""))
            txtLiters3.setText(CommonUtils.getPreference(this, SHAREDPREFERNCE_TOTAL3));
        disableAllRadioButtons();

        btnToggleStatic.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on == true) {
                    enableAllRadioButtons();
                } else {
                    disableAllRadioButtons();
                }
            }
        });
        btnToggle1.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on == true) {
                    etEndCounter1.setEnabled(true);
                } else {
                    etEndCounter1.setEnabled(false);
                }
            }
        });
        btnToggle2.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on == true) {
                    etEndCounter2.setEnabled(true);
                } else {
                    etEndCounter2.setEnabled(false);
                }
            }
        });
        btnToggle3.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on == true) {
                    etEndCounter3.setEnabled(true);
                } else {
                    etEndCounter3.setEnabled(false);
                }
            }
        });

        etEndCounter1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                valueOfEndCounter = Integer.valueOf(etEndCounter1.getText().toString().trim());
                int litersValue1 = valueOfEndCounter - Integer.valueOf(txtLastCounter1.getText().toString());
                txtLiters1.setText(String.valueOf(litersValue1));
                int lastCounter1 = valueOfEndCounter - Integer.valueOf(txtLiters1.getText().toString());
                txtLastCounter1.setText(String.valueOf(lastCounter1));

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
        etEndCounter2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                valueOfEndCounter2 = Integer.valueOf(etEndCounter2.getText().toString().trim());
                int litersValue2 = valueOfEndCounter2 - Integer.valueOf(txtLastCounter2.getText().toString());
                txtLiters2.setText(String.valueOf(litersValue2));
                int lastCounter2 = valueOfEndCounter2 - Integer.valueOf(txtLiters2.getText().toString());
                txtLastCounter2.setText(String.valueOf(lastCounter2));


            }
        });
        etEndCounter3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                valueOfEndCounter3 = Integer.valueOf(etEndCounter3.getText().toString().trim());
                int litersValue3 = valueOfEndCounter3 - Integer.valueOf(txtLastCounter3.getText().toString());
                txtLiters3.setText(String.valueOf(litersValue3));
                int lastCounter3 = valueOfEndCounter3 - Integer.valueOf(txtLiters3.getText().toString());
                txtLastCounter3.setText(String.valueOf(lastCounter3));

            }
        });

    }

    public void setDateAndTime() {
        // date and time
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT);
        String currentDateAndTime = sdf.format(new Date());
        txtStartShift.setText(currentDateAndTime);
        // add 12 hours
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 12);
        Date date = cal.getTime();
        String date1 = (new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT)).format(date);
        txtEndShift.setText(date1);
    }


    @OnClick(R.id.btn_next)
    public void onSaveClicked() {

        if (!TextUtils.isEmpty(etEndCounter1.getText().toString())) {
            int lastCounter1 = Integer.valueOf(txtLastCounter1.getText().toString()) + Integer.valueOf(txtLiters1.getText().toString().trim());
            CommonUtils.setPreference(this, SHAREDPREFERNCE_DISP1, String.valueOf(lastCounter1));
        }else {
            return;
        }
        if (!TextUtils.isEmpty(etEndCounter2.getText().toString())) {
            int lastCounter2 = Integer.valueOf(txtLastCounter2.getText().toString()) + Integer.valueOf(txtLiters2.getText().toString().trim());
            CommonUtils.setPreference(this, SHAREDPREFERNCE_DISP2, String.valueOf(lastCounter2));
        }else {
            return;
        }
        if (!TextUtils.isEmpty(etEndCounter3.getText().toString())) {
            int lastCounter3 = Integer.valueOf(txtLastCounter3.getText().toString()) + Integer.valueOf(txtLiters3.getText().toString().trim());
            CommonUtils.setPreference(this,  SHAREDPREFERNCE_DISP3, String.valueOf(lastCounter3));
        }else {
            return;
        }
        if (!TextUtils.isEmpty(txtLiters1.getText().toString())) {
            int total1 = Integer.valueOf(etEndCounter1.getText().toString()) - Integer.valueOf(txtLastCounter1.getText().toString());
            CommonUtils.setPreference(this, SHAREDPREFERNCE_TOTAL1, String.valueOf(total1));
        }else {
            return;
        }
        if (!TextUtils.isEmpty(txtLiters2.getText().toString())) {
            int total2 = Integer.valueOf(etEndCounter2.getText().toString()) - Integer.valueOf(txtLastCounter2.getText().toString());
            CommonUtils.setPreference(this, SHAREDPREFERNCE_TOTAL2, String.valueOf(total2));
        }else {
            return;
        }
        if (!TextUtils.isEmpty(txtLiters3.getText().toString())) {
            int total3 = Integer.valueOf(etEndCounter3.getText().toString()) - Integer.valueOf(txtLastCounter3.getText().toString());
            CommonUtils.setPreference(this, SHAREDPREFERNCE_TOTAL3, String.valueOf(total3));
        }else {
            return;
        }
        startActivity(new Intent(ShiftActivity.this, TankActivity.class));

        finish();
    }

    @OnClick(R.id.btn_cancel)
    public void onCancelClicked() {
        finish();
    }


    private void disableAllRadioButtons() {
        btnToggle1.setEnabled(false);
        btnToggle2.setEnabled(false);
        btnToggle3.setEnabled(false);
        etEndCounter1.setEnabled(false);
        etEndCounter2.setEnabled(false);
        etEndCounter3.setEnabled(false);
        btnToggle1.setToggleOff();
        btnToggle2.setToggleOff();
        btnToggle3.setToggleOff();
    }

    private void enableAllRadioButtons() {
        btnToggle1.setEnabled(true);
        btnToggle2.setEnabled(true);
        btnToggle3.setEnabled(true);
    }

    @Override
    protected void setUp() {
    }
}
