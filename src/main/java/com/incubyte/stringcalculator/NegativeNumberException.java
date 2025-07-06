package com.incubyte.stringcalculator;

import java.util.List;

public class NegativeNumberException extends RuntimeException {
    private final List<Integer> negatives;

    public NegativeNumberException(List<Integer> negatives) {
        super("negatives not allowed: " + negatives); // Pass message to superclass
        this.negatives = negatives;
    }

    public List<Integer> getNegatives() {
        return negatives;
    }

    @Override
    public String toString() {
        return getMessage(); // Optional override
    }
}
