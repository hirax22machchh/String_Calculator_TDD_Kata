package com.incubyte.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // Keeps count of how many times the add method was called
    private int callCount = 0;

    // Returns how many times add() method has been invoked
    public int getCalledCount() {
        return callCount;
    }

    // Main method to add numbers from the string input
    public int add(String numbers) {
        callCount++;

        // Check if the input string is null or empty
        if (isNullOrEmpty(numbers)) {
            return 0;
        }

        // Get the delimiter regex (custom or default)
        String delimiter = getDelimiter(numbers);

        // Remove the delimiter declaration line from the input
        String cleanedInput = removeDelimiterDeclaration(numbers);

        // Split the string into number parts using the delimiter regex
        String[] parts = cleanedInput.split(delimiter);

        return calculateSum(parts);
    }

    // --- Helper Methods ---

    // Checks if the input string is null or empty
    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    // Returns a string containing the delimiter regex
    private String getDelimiter(String input) {
        String defaultDelimiters = "[,\n]";

        // If no custom delimiter is specified, return default
        if (!input.startsWith("//")) {
            return defaultDelimiters;
        }

        // Extract the custom delimiter declaration
        int delimiterEnd = input.indexOf('\n');
        String delimiterLine = input.substring(2, delimiterEnd);

        // If multiple delimiters are declared (with square brackets)
        if (delimiterLine.startsWith("[") && delimiterLine.endsWith("]")) {
            return buildMultipleDelimiterRegex(delimiterLine);
        } else {
            // Single custom delimiter
            return "[,\n" + Pattern.quote(delimiterLine) + "]";
        }
    }

    // Removes the custom delimiter declaration part from the input
    private String removeDelimiterDeclaration(String input) {
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf('\n');
            return input.substring(delimiterEnd + 1);
        }
        return input;
    }

    // Builds the regex for splitting on multiple delimiters
    private String buildMultipleDelimiterRegex(String delimiterLine) {
        Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterLine);
        StringBuilder regex = new StringBuilder("(");
        boolean first = true;

        // Loop through all delimiters enclosed in []
        while (matcher.find()) {
            if (!first) regex.append("|");
            regex.append(Pattern.quote(matcher.group(1)));
            first = false;
        }

        regex.append(")");
        return regex.toString();
    }

    // Calculates the sum of numbers; throws exception for negatives
    private int calculateSum(String[] parts) {
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            int number = Integer.parseInt(part.trim());

            // Collect negative numbers for exception
            if (number < 0) {
                negatives.add(number);
            }
            // Ignore numbers greater than 1000
            else if (number <= 1000) {
                sum += number;
            }
        }

        // If any negatives found, throw custom exception
        if (!negatives.isEmpty()) {
            throw new NegativeNumberException(negatives);
        }

        return sum;
    }
}
