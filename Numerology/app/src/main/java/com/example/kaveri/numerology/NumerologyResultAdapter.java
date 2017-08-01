package com.example.kaveri.numerology;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by KAVERI on 7/30/2017.
 */
public class NumerologyResultAdapter extends BaseAdapter{

    private final List<NumerologyResultData> mNumerologyResultData;

    public NumerologyResultAdapter(List<NumerologyResultData> numerologyResultData){
        this.mNumerologyResultData = numerologyResultData;
    }
    @Override
    public int getCount() {
        return mNumerologyResultData.size();
    }

    @Override
    public Object getItem(int position) {
        return mNumerologyResultData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
