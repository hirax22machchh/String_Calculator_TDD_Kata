package com.incubyte.stringcalculator;

public class StringCalculator {
    public int add(String numbers){

        //checks if string of numbers is null or empty if it is, then it return 0
        if(numbers == null || numbers.isEmpty())
        {
            return 0;
        }

        //splitting the numbers from comma(,)
        String[] parts = numbers.split(",");
        int sum = 0;

        //after split if there is some white space around numbers, then this removes it, and does the sum of the numbers
        for(String part : parts)
        {
            sum += Integer.parseInt(part.trim());
        }

        return sum;
    }
}
