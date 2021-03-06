package com.zipcodewilmington;

import java.util.*;
import java.util.stream.IntStream;

import static java.lang.System.*;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // WORKING
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */ //WORKING
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */
    //WORKING
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */
    //WORKING
    public static String getSecondToLastElement(String[] array) {

        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // WORKING
    public static boolean contains(String[] array, String value) {
        boolean presentOrNot = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return true;
            } else {
                presentOrNot = false;
            }
        }
        return presentOrNot;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // WORKING
    public static String[] reverse(String[] array) {
        List<String> list = Arrays.asList(array);
        Collections.reverse(list);
        String[] revArr = list.toArray(array);
        return revArr;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // WORKING
    public static boolean isPalindromic(String[] array) {
        Boolean revOrNot = false;
        for (int i = 0; i < array.length / 2; i++) {
            if (!array[i].equalsIgnoreCase((array[array.length - i - 1]))) {
                revOrNot = false;
            } else {
                revOrNot = true;
            }
        }
        return revOrNot;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // WORKING
    public static boolean isPangramic(String[] array) {
        boolean isOrIsnt = false;
        boolean[] mark = new boolean[26];
        String concatStr = "";
        for (int i = 0; i < array.length; i++) {
            concatStr = concatStr.concat(array[i]);
        }
        concatStr = concatStr.toUpperCase();
        int index = 0;
        for (int i = 0; i < concatStr.length(); i++) {
            if ('A' <= concatStr.charAt(i) && concatStr.charAt(i) <= 'Z') {
                index = concatStr.charAt(i) - 'A';
            } else {
                continue;
            }
            mark[index] = true;
        }
        for (int i = 0; i <= 25; i++) {
            if (mark[i] == false) {
                isOrIsnt = false;
            } else {
                isOrIsnt = true;
            }
        }
    return isOrIsnt;
    }
    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // WORKING
    public static int getNumberOfOccurrences(String[] array, String value) {
        int numOfTimes = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(value)) {
                numOfTimes++;
            }
        }
        return numOfTimes;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // WORKING
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> output = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(valueToRemove)) {
                continue;
            } else {
                output.add(array[i]);
                counter++;
            }
        }
        String[] outArr = output.toArray(new String[counter]);
        return outArr;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // WORKING
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (!array[i - 1].equals(array[i])) {
                strList.add(array[i]);
            }
        }
        String[] outStrArr = strList.toArray(new String[0]);
        return outStrArr;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // WORKING
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> midList = new ArrayList<>();
        String strHolder = "";
        int counter = 0;
        int compare = counter + 1;
        while (counter < array.length) {
            strHolder = strHolder.concat(array[counter]);
            while (compare != array.length && array[counter].equals(array[compare])) {
                strHolder = strHolder.concat(array[compare]);
                compare++;
            }
            midList.add(strHolder);
            strHolder = "";
            counter = compare;
            compare++;
        }
        String[] outArr = midList.toArray(new String[0]);
        return outArr;
    }
}
