package com.incubyte.stringcalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    //for empty string - returns 0
    @Test
    void addEmptyStringReutrnsZero(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0,result);
    }

    //for single number - returns number itself
    @Test
    void addSingleNumberReturnsItself(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("22");
        assertEquals(22,result);
    }

    //for two numbers - returns sum of two numbers
    @Test
    void addTwoCommaSeparatedNumbersReturnsTheirSum() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,5");
        assertEquals(6, result);
    }


    //for more than two numbers - returns sum of them
    @Test
    void addCommaSeparatedNumbersReturnsSum(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("2,4,6");
        assertEquals(12,result);
     }
}
