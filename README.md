# String Calculator TDD Kata (Java + Gradle)

This project implements the **String Calculator Kata** using the **Test-Driven Development (TDD)** approach in **Java** with **JUnit 5** and **Gradle**.

---

## Overview

The goal of this kata is to build a `StringCalculator` class that parses a string of numbers and returns their sum, while evolving functionality step-by-step using unit tests.

---

## Technologies Used

- **Java 17+**
- **Gradle** (as build tool)
- **JUnit 5** (for unit testing)
- **IntelliJ IDEA** (as development environment)

---

## Features Implemented

| Step | Feature Description |
|------|----------------------|
| 1    | Add empty, single, or two comma-separated numbers |
| 2    | Support any amount of comma-separated numbers |
| 3    | Support newlines (`\n`) as delimiters |
| 4    | Support custom single-character delimiters (e.g., `//;\n1;2`) |
| 5-6  | Throw exception for negative numbers, listing all of them |
| 7    | Track the number of times `add()` is called |
| 9    | Ignore numbers greater than 1000 |
| 10   | Support delimiters of any length (e.g., `[***]`) |
| 11   | Support multiple custom delimiters (e.g., `[*][%]`) |
| 12   | Support multiple delimiters of different lengths (e.g., `[**][%%]`) |

---

## Project Structure

src
└── main
└── java
└── com.incubyte.stringcalculator
└── StringCalculator.java

└── test
└── java
└── com.incubyte.stringcalculator
└── StringCalculatorTest.java

## Contact
Author: Hirax Machchh
Email: machchh.hirax@gmail.com
GitHub: https://github.com/hirax22machchh

