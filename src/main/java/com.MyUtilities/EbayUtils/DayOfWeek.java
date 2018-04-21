package com.MyUtilities.EbayUtils;

/**
 * Created by moshe on 24/05/2017.
 */
public enum DayOfWeek{

    SUNDAY("1"),
    MONDAY("2"),
    TUESDAY("3"),
    WEDNESDAY("4"),
    THURSDAY("5"),
    FRIDAY("6"),
    SATURDAY("7");

    String dayInNumber;
    DayOfWeek(String numberOfDay){
        this.dayInNumber =numberOfDay;
    }


    @Override
    public String toString() {
        return dayInNumber;
    }

}
