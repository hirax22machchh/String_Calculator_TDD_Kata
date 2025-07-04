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

    //for numbers string with new lines in it - returns sum of numbers


}
