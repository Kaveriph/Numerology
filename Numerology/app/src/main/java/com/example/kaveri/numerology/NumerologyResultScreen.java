package com.example.kaveri.numerology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KAVERI on 7/30/2017.
 */
public class NumerologyResultScreen extends AppCompatActivity {

    private static final String TAG = NumerologyResultScreen.class.getSimpleName();
    private RecyclerView numerologyResulList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_numerology_result_screen);
        initData();
        initUI();
    }

    private void initData() {
        Intent numerologyInetnt = getIntent();
        String name = numerologyInetnt.getStringExtra(AppConstants.NAME);
        String dob =numerologyInetnt.getStringExtra(AppConstants.DOB);
        String mobile = numerologyInetnt.getStringExtra(AppConstants.MOBILE);
        String vehicle = numerologyInetnt.getStringExtra(AppConstants.VEHICLE);

        int nameTotalValue = calculateTotalValue(name);
        int dobTotalValue = calculateTotalValue(dob);
        int mobileTotalValue = calculateTotalValue(mobile);
        int vehicleTotalValue = calculateTotalValue(vehicle);

        int namePyramidValue = calculatePyramidValue(name);
        int dobPyramidValue = calculatePyramidValue(dob);
        int mobilePyramidValue = calculatePyramidValue(mobile);
        int vehiclePyramidValue = calculatePyramidValue(vehicle);

        Log.d(TAG, "total : "+nameTotalValue+", "+dobTotalValue+", "+mobileTotalValue+", "+vehicleTotalValue);
        Log.d(TAG, "pyramid : "+namePyramidValue+", "+dobPyramidValue+", "+mobilePyramidValue+", "+vehiclePyramidValue);
        List<NumerologyResultData> mNumerologyResultData = new ArrayList<>();
        NumerologyResultAdapter numerologyResultAdapter = new NumerologyResultAdapter(mNumerologyResultData);
    }

    private int calculatePyramidValue(String name) {
        String pyramidValue = "";
        CharSequence nameCharSeq = name;
        if(nameCharSeq.length() > 2) {
            for (int i = 0; i < nameCharSeq.length(); i++) {
                int charEquivalentValue = getEquivalentCharValue(nameCharSeq.charAt(i));
                if(charEquivalentValue != -1)
                    pyramidValue = pyramidValue + charEquivalentValue;
            }
            return generatePyramid(pyramidValue);
        }
        return Integer.parseInt(name);
    }

    private int generatePyramid(String pyramidValue) {
        if(pyramidValue.length() > 2) {
            String newPyramidValue = "";
            for(int i=0; i<pyramidValue.length()-1 ;i++) {
                newPyramidValue = newPyramidValue + sumUpIndividualNum(Integer.parseInt(pyramidValue.substring(i, i+2)));
            }
          return generatePyramid(newPyramidValue);
        }
        return Integer.parseInt(pyramidValue);
    }

    private int calculateTotalValue(String name) {
        if(!TextUtils.isEmpty(name)) {
            int totalValue = 0;
            CharSequence nameChar = name;
            for (int i =0; i < nameChar.length(); i++) {
                int equivalentCharValue = getEquivalentCharValue(nameChar.charAt(i));
                if(equivalentCharValue != -1)
                    totalValue = totalValue + equivalentCharValue;
            }
            return sumUpIndividualNum(totalValue);
        }
        return 0;
    }

    private int sumUpIndividualNum(int totalValue) {
        if(totalValue > 9) {
            int newTotalValue = 0;
            CharSequence totalValueStr = String.valueOf(totalValue);
            for (int i = 0; i < totalValueStr.length(); i++) {
                newTotalValue = newTotalValue + Integer.parseInt(String.valueOf(totalValueStr.charAt(i)));
            }
            return sumUpIndividualNum(newTotalValue);
        } else
            return totalValue;
    }

    private int getEquivalentCharValue(Character c) {
        if(Character.isDigit(c))
            return Integer.parseInt(String.valueOf(c));
        List<CharacterValue> chartArray = AppConstants.getChartList();
        for (CharacterValue chart : chartArray) {
            if (Character.toLowerCase(chart.getCharacter()) == Character.toLowerCase(c))
                return chart.getValue();
        }
        return -1;
    }

    private void initUI() {
        numerologyResulList = (RecyclerView) findViewById(R.id.numerologyResultList);

    }

}
