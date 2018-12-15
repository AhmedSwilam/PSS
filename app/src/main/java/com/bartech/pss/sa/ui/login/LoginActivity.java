/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.bartech.pss.sa.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bartech.pss.sa.R;
import com.bartech.pss.sa.data.network.model.Datum;
import com.bartech.pss.sa.data.network.model.DatumBranch;
import com.bartech.pss.sa.data.network.model.LoginResponsePss;
import com.bartech.pss.sa.ui.Shift.ShiftActivity;
import com.bartech.pss.sa.ui.base.BaseActivity;
import com.bartech.pss.sa.utils.CommonUtils;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by janisharali on 27/01/17.
 */

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;
    private ArrayAdapter<Datum> companySpinnerAdapter;
    private ArrayAdapter<DatumBranch> branchSpinnerAdapter;
    private String companyId;
    private String branchId;
    @BindView(R.id.et_username)
    EditText mUserNameEditText;
    @BindView(R.id.et_password)
    EditText mPasswordEditText;
    @BindView(R.id.img_sign_in)
    ImageView imgLogin;
    @BindView(R.id.btn_forgot)
    Button imgForgot;
    @BindView(R.id.img_getsupport)
    ImageView imgGetSupport;
    @BindView(R.id.spinner_company)
    SearchableSpinner spinnerCompany;
    @BindView(R.id.spinner_branch)
    SearchableSpinner spinnerBranch;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideKeyboard();
        setContentView(R.layout.activity_login);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(LoginActivity.this);

        mPresenter.getCompanyName();

        mPresenter.getBranchName("CompanyId");
    }

    @OnClick(R.id.img_sign_in)
    void onServerLoginClick(View v) {
        if (companyId != null && branchId != null) {
            if (companyId.length() != 0 && branchId.length() != 0) {
                mPresenter.onServerLoginClick(mUserNameEditText.getText().toString(), mPasswordEditText.getText().toString(),
                        companyId, branchId);
            }
        }
    }

    @Override
    public void openShiftActivity() {
        startActivity(new Intent(LoginActivity.this, ShiftActivity.class));
        finish();
    }

    @Override
    public void setCompanyName(final List<Datum> data) {
        companySpinnerAdapter = new ArrayAdapter<Datum>(this,
                android.R.layout.simple_spinner_item, android.R.id.text1);
        companySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCompany.setAdapter(companySpinnerAdapter);
        companySpinnerAdapter.addAll(data);
        spinnerCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                companyId = data.get(position).getId().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                companyId = null;
            }
        });

    }

    @Override
    public void setBranchName(final List<DatumBranch> dataBranch) {
        branchSpinnerAdapter = new ArrayAdapter<DatumBranch>(this,
                android.R.layout.simple_spinner_item, android.R.id.text1);
        branchSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBranch.setAdapter(branchSpinnerAdapter);
        branchSpinnerAdapter.addAll(dataBranch);
        spinnerBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                branchId = dataBranch.get(position).getId().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                branchId = null;
            }
        });
    }

    @Override
    public void saveLoginResponsePss(LoginResponsePss loginResponsePss) {
        CommonUtils.saveUser(this,loginResponsePss);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}
