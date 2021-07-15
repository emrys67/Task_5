package com.foxminded.task_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;
    private static final String CHARS_NULL = "Null input is not allowed";
    private static final String EMPTY = "";
    private static final String CHAR_WITH_DIGITS_AND_SYMBOLS_UPPER_KEYS = "Hello1$$ WO11rld";
    private static final String CHAR_WITH_DIGITS_AND_SYMBOLS_LOWER_KEYS = "hello1$$ wo11rld";
    private static final String CHARS_WITH_UPPER_KEYS = "Hello WOrld!";
    private static final String CHARS_WITH_LOWER_KEYS = "hello world!";

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void countCharsEmpty() {
        Cash actual = calculator.fillMap(EMPTY);
        HashMap<Character, Integer> cashMap = new HashMap<>();
        Cash expected = new Cash(cashMap, EMPTY);
        assertEquals(expected, actual);
    }

    @Test
    void countCharsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.fillMap(null);
        });
        String actual = exception.getMessage();
        assertEquals(CHARS_NULL, actual);
    }

    @Test
    void countCharsSWithUpperKeys() {
        Cash actual = calculator.fillMap(CHARS_WITH_UPPER_KEYS);
        HashMap<Character, Integer> cashMap = new HashMap<>();
        cashMap.put(' ', 1);
        cashMap.put('!', 1);
        cashMap.put('h', 1);
        cashMap.put('e', 1);
        cashMap.put('l', 3);
        cashMap.put('o', 2);
        cashMap.put('w', 1);
        cashMap.put('r', 1);
        cashMap.put('d', 1);
        Cash expected = new Cash(cashMap, CHARS_WITH_UPPER_KEYS);
        assertEquals(expected, actual);
    }

    @Test
    void countCharsWithDigitsAndSymbols() {
        Cash actual = calculator.fillMap(CHAR_WITH_DIGITS_AND_SYMBOLS_UPPER_KEYS);
        HashMap<Character, Integer> cashMap = new HashMap<>();
        cashMap.put(' ', 1);
        cashMap.put('h', 1);
        cashMap.put('e', 1);
        cashMap.put('l', 3);
        cashMap.put('o', 2);
        cashMap.put('1', 3);
        cashMap.put('$', 2);
        cashMap.put('w', 1);
        cashMap.put('r', 1);
        cashMap.put('d', 1);
        Cash expected = new Cash(cashMap, CHAR_WITH_DIGITS_AND_SYMBOLS_UPPER_KEYS);
        assertEquals(expected, actual);
    }

    @Test
    void countCharsWithLowerKeys() {
        Cash actual = calculator.fillMap(CHARS_WITH_LOWER_KEYS);
        HashMap<Character, Integer> cashMap = new HashMap<>();
        cashMap.put(' ', 1);
        cashMap.put('!', 1);
        cashMap.put('h', 1);
        cashMap.put('e', 1);
        cashMap.put('l', 3);
        cashMap.put('o', 2);
        cashMap.put('w', 1);
        cashMap.put('r', 1);
        cashMap.put('d', 1);
        Cash expected = new Cash(cashMap, CHARS_WITH_LOWER_KEYS);
        assertEquals(expected, actual);
    }

    @Test
    void countCharsTwoTimesWithDifferentInput() {
        calculator.fillMap(CHAR_WITH_DIGITS_AND_SYMBOLS_LOWER_KEYS);
        Cash actual = calculator.fillMap(CHARS_WITH_LOWER_KEYS);
        HashMap<Character, Integer> cashMap = new HashMap<>();
        cashMap.put(' ', 1);
        cashMap.put('!', 1);
        cashMap.put('h', 1);
        cashMap.put('e', 1);
        cashMap.put('l', 3);
        cashMap.put('o', 2);
        cashMap.put('w', 1);
        cashMap.put('r', 1);
        cashMap.put('d', 1);
        Cash expected = new Cash(cashMap, CHARS_WITH_LOWER_KEYS);
        assertEquals(expected, actual);
    }
}
