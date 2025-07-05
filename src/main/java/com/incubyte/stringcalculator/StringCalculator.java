package com.incubyte.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private int callCount = 0;

    public int getCalledCount() {
        return callCount;
    }

    public int add(String numbers) {
        callCount++;

        if (isNullOrEmpty(numbers)) {
            return 0;
        }

        String delimiter = getDelimiter(numbers);
        numbers = removeDelimiterDeclaration(numbers);

        String[] parts = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = calculateSum(parts, negatives);

        if (!negatives.isEmpty()) {
            throw new RuntimeException("negatives not allowed: " + negatives);
        }

        return sum;
    }

    // --- Helper Methods ---

    // Checks if the input string is null or empty
    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    // Returns a string of delimiters if it is there otherwise returns default delimiters
    private String getDelimiter(String input) {
        String defaultDelimiters = "[,\n]";

        // if there are no delimiters specified, then returns default delimiters.
        if (!input.startsWith("//")) {
            return defaultDelimiters;
        }

        //create delimiterLine string which contains unknown delimiters
        int delimiterEnd = input.indexOf('\n');
        String delimiterLine = input.substring(2, delimiterEnd);

        //extract multiple delimiters from delimiterLine
        if (delimiterLine.startsWith("[") && delimiterLine.endsWith("]")) {
            return buildMultipleDelimiterRegex(delimiterLine);
        } else {
            return "[,\n" + Pattern.quote(delimiterLine) + "]";
        }
    }

    // Removes delimiters declaration from main String and returns input string
    private String removeDelimiterDeclaration(String input) {
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf('\n');
            return input.substring(delimiterEnd + 1);
        }
        return input;
    }

    // builds regular expression for delimiter extraction
    private String buildMultipleDelimiterRegex(String delimiterLine) {
        Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterLine);
        StringBuilder regex = new StringBuilder("(");
        boolean first = true;

        while (matcher.find()) {
            if (!first) regex.append("|");
            regex.append(Pattern.quote(matcher.group(1)));
            first = false;
        }

        regex.append(")");
        return regex.toString();
    }

    //calculates sum
    private int calculateSum(String[] parts, List<Integer> negatives) {
        int sum = 0;
        for (String part : parts) {
            int number = Integer.parseInt(part.trim());
            if (number < 0) {
                negatives.add(number);
            } else if (number <= 1000) {
                sum += number;
            }
        }
        return sum;
    }
}
