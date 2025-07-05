package com.incubyte.stringcalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    // --- Step - 1  (Handle empty, single, and two numbers) ---

    //for empty string - returns 0
    @Test
    void add_Empty_String_Returns_Zero(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0,result);
    }

    //for single number - returns number itself
    @Test
    void add_Single_Number_Returns_Itself(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("22");
        assertEquals(22,result);
    }

    //for two numbers - returns sum of two numbers
    @Test
    void add_Two_Comma_Separated_Numbers_Returns_Sum() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,5");
        assertEquals(6, result);
    }

    // --- Step - 2 (Handle more than two numbers string) ---

    //for more than two numbers - returns sum of numbers
    @Test
    void add_Multiple_Comma_Separated_Numbers_Returns_Sum(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20");
        assertEquals(210,result);
    }

    // --- Step - 3 (Handle new lines between string) ---

    //for numbers string having only new lines - returns sum of numbers ignores new line
    @Test
    void add_Numbers_With_Only_Newlines_Returns_Sum(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("4\n5\n6");
        assertEquals(15,result);
    }

    //for numbers string with comma and new line in it - returns sum of numbers ignores new lines and comma
    @Test
    void add_Numbers_with_Newline_And_Comma_Returns_Sum(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2,3\n4,5");
        assertEquals(15,result);
    }

    // --- Step - 4 (Handle different delimiters) ---

    //for numbers string with diff delimiters, comma, and newline - returns sum of numbers
    @Test
    void add_Numbers_With_Custom_Delimiter_Comma_And_Newline(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//;\n1;2");
        assertEquals(3,result);
        System.out.println("The result is"+result);
    }

    // --- Step - 5 & 6 (Handle negative numbers with exception) ---

    //for numbers string with negative numbers - returns exception with negative values
    @Test
    void add_Numbers_With_NegativeNumber_ThrowsException_With_Message(){
        StringCalculator calculator = new StringCalculator();
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.add("1,-2,3,-4,-5"));
        assertEquals("negatives not allowed: [-2, -4, -5]",exception.getMessage());
    }

    // --- Step-7 (For checking method GetCalledCount) ---

    //for counting of Add method calls - returns count of Add method calls
    @Test
    void getCalledCount_Returns_CountOf_Add_Method_Calls(){
        StringCalculator calculator = new StringCalculator();
        calculator.add("1,2");
        calculator.add("1,2,3");
        assertEquals(2,calculator.GetCalledCount());
    }

    // --- Step - 9 (Numbers greater than 1000 should be ignored) ---

    //for numbers greater than 1000 are ignored - returns sum with ignoring of numbers greater than 1000
    @Test
    void add_Numbers_Greater_Than_1000_Are_Ignored(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,1000,1002,2000,2");
        assertEquals(1003,result);
    }

    // Step - 10 (Handling delimiters of any length) ---

    //for delimiters having any length - returns sum of numbers
    @Test
    void add_Numbers_With_Delimiters_Of_Any_Length(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[***]\n1***2***3");
        assertEquals(6,result);
    }

    //for handling of multiple delimiters - returns sum of numbers
    @Test
    void add_Numbers_With_Allowing_Multiple_Delimiters(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }

}
