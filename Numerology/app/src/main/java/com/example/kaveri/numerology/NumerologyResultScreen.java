package com.example.kaveri.numerology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initUI();
        initData();
    }

    private void initData() {
        Intent numerologyInetnt = getIntent();
        String name = numerologyInetnt.getStringExtra(AppConstants.NAME);
        String dob =numerologyInetnt.getStringExtra(AppConstants.DOB);
        String mobile = numerologyInetnt.getStringExtra(AppConstants.MOBILE);
        String vehicle = numerologyInetnt.getStringExtra(AppConstants.VEHICLE);

        List<NumerologyResultData> mNumerologyResultData = new ArrayList<>();

        if(!TextUtils.isEmpty(name)) {
            int nameTotalValue = calculateTotalValue(name);
            int namePyramidValue = calculatePyramidValue(name);
            mNumerologyResultData.add(new NumerologyResultData(name, nameTotalValue, namePyramidValue));
        }
        if(!TextUtils.isEmpty(dob)) {
            int dobTotalValue = calculateTotalValue(dob);
            int dobPyramidValue = calculatePyramidValueForDate(dob);
            mNumerologyResultData.add(new NumerologyResultData(dob, dobTotalValue, dobPyramidValue));
        }
        if(!TextUtils.isEmpty(mobile)) {
            int mobileTotalValue = calculateTotalValue(mobile);
            int mobilePyramidValue = calculatePyramidValue(mobile);
            mNumerologyResultData.add(new NumerologyResultData(mobile, mobileTotalValue, mobilePyramidValue));
        }
        if(!TextUtils.isEmpty(vehicle)) {
            int vehicleTotalValue = calculateTotalValue(vehicle);
            int vehiclePyramidValue = calculatePyramidValue(vehicle);
            mNumerologyResultData.add(new NumerologyResultData(vehicle, vehicleTotalValue, vehiclePyramidValue));
        }
        NumerologyResultAdapter numerologyResultAdapter = new NumerologyResultAdapter(mNumerologyResultData);
        numerologyResulList.setAdapter(numerologyResultAdapter);
    }

    private int calculatePyramidValue(String name) {
        String pyramidValue = "";
        CharSequence nameCharSeq = name;
        if(nameCharSeq.length() > 2) {
            pyramidValue = getEquivalentNumGeneratePyramid(pyramidValue, nameCharSeq);
            return generatePyramid(pyramidValue);
        }

        return pyramidValForSingleLetter(name, pyramidValue, nameCharSeq);

    }


    private int calculatePyramidValueForDate(String name) {

        String day = name.substring(0,2);
        String month = name.substring(3,5);
        String year = name.substring(6);
        String mainString = calculatePyramidValueForDatePart(day)+""+calculatePyramidValueForDatePart(month)
                +""+calculatePyramidValueForDatePart(year)+"";
        return calculatePyramidValue(mainString);
    }

    private int calculatePyramidValueForDatePart(String name) {
        String pyramidValue = "";
        CharSequence nameCharSeq = name;
        if(nameCharSeq.length() > 1) {
            pyramidValue = getEquivalentNumGeneratePyramid(pyramidValue, nameCharSeq);
            return generatePyramidForDatePart(pyramidValue);
        }

        return pyramidValForSingleLetter(name, pyramidValue, nameCharSeq);

    }

    private int pyramidValForSingleLetter(String name, String pyramidValue, CharSequence nameCharSeq) {
        if(Character.isDigit(nameCharSeq.charAt(0))){
            if( nameCharSeq.length() > 1) {
                if(Character.isDigit(nameCharSeq.charAt(1)))
                    return Integer.parseInt(name);
                else
                    return Integer.parseInt(getEquivalentNumGeneratePyramid(pyramidValue, nameCharSeq));
            } else
                return Integer.parseInt(name);
        } else
            return Integer.parseInt(getEquivalentNumGeneratePyramid(pyramidValue, nameCharSeq));
    }

    private String getEquivalentNumGeneratePyramid(String pyramidValue, CharSequence nameCharSeq) {
        for (int i = 0; i < nameCharSeq.length(); i++) {
            int charEquivalentValue = getEquivalentCharValue(nameCharSeq.charAt(i));
            if(charEquivalentValue != -1)
                pyramidValue = pyramidValue + charEquivalentValue;
        }
        return pyramidValue;
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

    private int generatePyramidForDatePart(String pyramidValue) {
        if(pyramidValue.length() > 1) {
            String newPyramidValue = "";
            for(int i=0; i<pyramidValue.length()-1 ;i++) {
                newPyramidValue = newPyramidValue + sumUpIndividualNum(Integer.parseInt(pyramidValue.substring(i, i+2)));
            }
            return generatePyramidForDatePart(newPyramidValue);
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
            return totalValue;
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
        numerologyResulList.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        numerologyResulList.setLayoutManager(mLayoutManager);
    }

}
