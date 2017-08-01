package com.example.kaveri.numerology;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by KAVERI on 7/30/2017.
 */
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private DateListener dateListener;

    public DatePickerFragment(){}
    public DatePickerFragment(DateListener dateListener) {
        this.dateListener = dateListener;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        dateListener.onDateSelected(year, month, day);
    }
}
