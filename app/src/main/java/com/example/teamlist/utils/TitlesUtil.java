package com.example.teamlist.utils;

public class TitlesUtil {

    public static final String TITLES_PLURAL = " titles";
    public static final String TITLES_SINGULAR = " title";

    public static String formatTitles(int numberOfTitles) {
        if(numberOfTitles > 1) {
            return numberOfTitles + TITLES_PLURAL;
        } else if(numberOfTitles == 0) {
            return "No" + TITLES_PLURAL;
        }
        return numberOfTitles + TITLES_SINGULAR;
    }
}
