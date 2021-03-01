package com.masiv.cleancode.roulette.util.constants;

import java.util.Date;

public class Constants {
    public static final String RED = "ROJO";
    public static final String BLACK = "NEGRO";
    public static final String OPEN = "OPEN";
    public static final String CLOSE = "CLOSE";
    public static final int NUMBERS_ROULETTE = 36;
    public static final double LIMIT_ROULETTE = 10000;
    public static String GENERATE_ID(){
        Date date = new Date();
        return String.valueOf(date.getTime());
    }
}
