package com.example.kaveri.numerology;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KAVERI on 7/30/2017.
 */
public class AppConstants {
    public static final String NAME = "NAME";
    public static final String DOB = "DOB";
    public static final String MOBILE = "MOBILE";
    public static final String VEHICLE = "VEHICLE";
    //public static List<CharacterValue> chartArray = getChartList();
    private static int number_one = 1;
    private static int number_two = 2;
    private static int number_three = 3;
    private static int number_four= 4;
    private static int number_five = 5;
    private static int number_six = 6;
    private static int number_seven = 7;
    private static int number_eight = 8;

    public static List<CharacterValue> getChartList() {
        List<CharacterValue> chart = new ArrayList<CharacterValue>();
        chart.add(new CharacterValue('A', number_one));
        chart.add(new CharacterValue('I', number_one));
        chart.add(new CharacterValue('J', number_one));
        chart.add(new CharacterValue('Q', number_one));
        chart.add(new CharacterValue('Y', number_one));

        chart.add(new CharacterValue('B', number_two));
        chart.add(new CharacterValue('K', number_two));
        chart.add(new CharacterValue('R', number_two));

        chart.add(new CharacterValue('C', number_three));
        chart.add(new CharacterValue('G', number_three));
        chart.add(new CharacterValue('L', number_three));
        chart.add(new CharacterValue('S', number_three));

        chart.add(new CharacterValue('D', number_four));
        chart.add(new CharacterValue('M', number_four));
        chart.add(new CharacterValue('T', number_four));

        chart.add(new CharacterValue('H', number_five));
        chart.add(new CharacterValue('X', number_five));
        chart.add(new CharacterValue('N', number_five));
        chart.add(new CharacterValue('E', number_five));

        chart.add(new CharacterValue('U', number_six));
        chart.add(new CharacterValue('V', number_six));
        chart.add(new CharacterValue('W', number_six));

        chart.add(new CharacterValue('O', number_seven));
        chart.add(new CharacterValue('Z', number_seven));

        chart.add(new CharacterValue('P', number_eight));
        chart.add(new CharacterValue('F', number_eight));

        return chart;
    }
}
