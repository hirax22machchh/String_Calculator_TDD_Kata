package com.incubyte.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    //keeps count of how many times add method was called.
    private int callCount = 0;

    public int GetCalledCount(){
        return callCount;
    }

    public int add(String numbers){

        callCount++;  //incrementing call count of add method.

        //checks if string of numbers is null or empty if it is, then it return 0
        if(numbers == null || numbers.isEmpty())
        {
            return 0;
        }

        //this string contains the delimiter regular expression
        String delimiter = "[,\n]";

        //checks if custom delimiter is there in a string or not
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf('\n');
            String delimiterLine = numbers.substring(2, delimiterEnd);
            delimiter = "[\n," + Pattern.quote(delimiterLine) + "]";// escape any regex characters
            numbers = numbers.substring(delimiterEnd + 1); // actual number string
        }

        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        //splitting the numbers from delimiters
        String[] parts = numbers.split(delimiter);

        /*
         * This part removes extra white space from numbers,
         * And converts string to integer.
         * After that in if condition it checks for negative numbers,
         * If negative numbers are present then stores into array list.
         * And for positive numbers it adds to sum.
         */
        for(String part : parts)
        {
            int number = Integer.parseInt(part.trim());
            if(number<0)
            {
                negatives.add(number);
            }
            sum += number;
        }

        //if negative numbers are present in list then this part throws exception.
        if(!negatives.isEmpty())
        {
            throw new RuntimeException("negatives not allowed: "+negatives);
        }

        return sum;
    }
}
