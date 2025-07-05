package com.incubyte.stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers){

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
        //splitting the numbers from comma(,) and new_line(\n)
        String[] parts = numbers.split(delimiter);
        int sum = 0;

        //after split if there is some white space around numbers, then this removes it, and does the sum of the numbers
        for(String part : parts)
        {
            sum += Integer.parseInt(part.trim());
        }

        return sum;
    }
}
