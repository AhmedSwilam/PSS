package com.bartech.pss.sa.ui.tank;

import android.os.Bundle;
import android.widget.TextView;

import com.bartech.pss.sa.R;
import com.bartech.pss.sa.ui.base.BaseActivity;
import com.zcw.togglebutton.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ahmed on 4/28/2018.
 */

public class TankActivity extends BaseActivity implements TankMvpView {

    @BindView(R.id.txt_start_shift)
    TextView txtStartShift;
    @BindView(R.id.txt_end_shift)
    TextView txtEndShift;
    @BindView(R.id.toggele_static)
    ToggleButton btnToggleStatic;
    @BindView(R.id.toggele1)
    ToggleButton btnToggle1;
    @BindView(R.id.toggele2)
    ToggleButton btnToggle2;
    @BindView(R.id.toggele3)
    ToggleButton btnToggle3;


    @Inject
    TankMvpPresenter<TankMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideKeyboard();
        setContentView(R.layout.activity_tanks);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(TankActivity.this);
        setDateAndTime();

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
                } else {
                }
            }
        });
        btnToggle2.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on == true) {
                } else {
                }
            }
        });
        btnToggle3.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on == true) {
                } else {
                }
            }
        });

    }

    public void setDateAndTime() {
        // date and time
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm a");
        String currentDateAndTime = sdf.format(new Date());
        txtStartShift.setText(currentDateAndTime);
        // add 12 hours
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 12);
        Date date = cal.getTime();
        String date1 = (new SimpleDateFormat("dd/MM/yyyy  HH:mm a")).format(date);
        txtEndShift.setText(date1);
    }

    private void disableAllRadioButtons() {
        btnToggle1.setEnabled(false);
        btnToggle2.setEnabled(false);
        btnToggle3.setEnabled(false);
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
