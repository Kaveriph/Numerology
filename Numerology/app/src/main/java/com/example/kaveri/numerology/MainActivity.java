package com.example.kaveri.numerology;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, DateListener, TextWatcher, View.OnClickListener {

    private EditText mNameEt;
    private EditText mDobEt;
    private EditText mMobNumEt;
    private EditText mVehicleNumEt;
    private Button mCheckBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initUI();
        setListeners();
        checkIfReadyToSubmit();
        initData();
    }

    private void initData() {

    }

    private void initUI() {
        mNameEt = (EditText) findViewById(R.id.nameEt);
        mDobEt = (EditText) findViewById(R.id.dobEt);
        mMobNumEt = (EditText) findViewById(R.id.mobNumEt);
        mVehicleNumEt = (EditText) findViewById(R.id.vehicleNumEt);
        mCheckBtn = (Button) findViewById(R.id.check_btn);
        mMobNumEt.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    private void setListeners() {
        mDobEt.setOnTouchListener(this);
        mNameEt.addTextChangedListener(this);
        mDobEt.addTextChangedListener(this);
        mMobNumEt.addTextChangedListener(this);
        mVehicleNumEt.addTextChangedListener(this);
        mCheckBtn.setOnClickListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int DRAWABLE_RIGHT = 2;
        if(event.getAction() == MotionEvent.ACTION_UP) {
            if(event.getRawX() >= (v.getRight() - mDobEt.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                // your action here
                openCalendar();
                return true;
            }
        }
        return false;
    }

    private void openCalendar() {
        DialogFragment newFragment = new DatePickerFragment(this);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onDateSelected(int year, int month, int day) {
        int actualMonth = (month + 1);
        String actualMonthStr = prefixZero(actualMonth);
        String actualDateStr = prefixZero(day);
        mDobEt.setText(actualDateStr + "/" + actualMonthStr + "/" + year);
    }

    @NonNull
    private String prefixZero(int actualMonth) {
        String actualMonthStr;
        if(actualMonth <= 9)
            actualMonthStr = "0"+actualMonth;
        else
            actualMonthStr = actualMonth+"";
        return actualMonthStr;
    }

    private void checkIfReadyToSubmit() {
        if(!TextUtils.isEmpty(mNameEt.getText().toString()) || !TextUtils.isEmpty(mDobEt.getText().toString())
            || !TextUtils.isEmpty(mMobNumEt.getText().toString()) || !TextUtils.isEmpty(mVehicleNumEt.getText().toString()))
            enableDisable(true);
        else
            enableDisable(false);
    }

    private void enableDisable(boolean enableDisable) {
        mCheckBtn.setEnabled(enableDisable);
        if(enableDisable)
            mCheckBtn.setAlpha(1);
        else
            mCheckBtn.setAlpha((float) 0.4);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        checkIfReadyToSubmit();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.check_btn) {
            Intent numerologyInetnt = new Intent(this, NumerologyResultScreen.class);
            if(!TextUtils.isEmpty(mNameEt.getText()))
                numerologyInetnt.putExtra(AppConstants.NAME, mNameEt.getText().toString());
            if(!TextUtils.isEmpty(mDobEt.getText()))
                numerologyInetnt.putExtra(AppConstants.DOB, mDobEt.getText().toString());
            if(!TextUtils.isEmpty(mMobNumEt.getText()))
                numerologyInetnt.putExtra(AppConstants.MOBILE, mMobNumEt.getText().toString());
            if(!TextUtils.isEmpty(mVehicleNumEt.getText()))
                numerologyInetnt.putExtra(AppConstants.VEHICLE, mVehicleNumEt.getText().toString());
            startActivity(numerologyInetnt);
        }
    }
}
