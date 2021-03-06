package com.example.kaveri.numerology;

/**
 * Created by KAVERI on 7/30/2017.
 */
public class NumerologyResultData {

    private String name;
    private int totalValue;
    private int pyramidValue;

    public NumerologyResultData(String name, int totalValue, int puramidValue) {
        this.name = name;
        this.totalValue = totalValue;
        this.pyramidValue = puramidValue;
    }

    @Override
    public String toString() {
        return "NumerologyResultData{" +
                "name='" + name + '\'' +
                ", totalValue=" + totalValue +
                ", pyramidValue=" + pyramidValue +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    public int getPyramidValue() {
        return pyramidValue;
    }

    public void setPyramidValue(int pyramidValue) {
        this.pyramidValue = pyramidValue;
    }
}
