package edu.rice.comp504.util;

import java.awt.*;

/**
 * Utility used to generate random numbers.
 */
public class RandUtil {

    private static RandUtil ONLY = null;
    protected static String[] availColors = {"red", "blue", "yellow", "green", "black", "purple", "orange", "gray", "brown"};
    /**
     * Generate a random number.
     * @param base  The mininum value
     * @param limit The maximum number from the base
     * @return A randomly generated number
     */
    public static int getRnd(int base, int limit) {
        return (int)Math.floor(Math.random() * limit + base);
    }

    public static String getRandColor() {
        return availColors[getRnd(0,8)];
    }


}
