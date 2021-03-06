package com.foxminded.task_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private static final String CHARS_NULL_OR_EMPTY = "Null and empty input is not allowed";
    private static final String EMPTY = "";
    private static final String CHAR_WITH_DIGITS_AND_SYMBOLS_UPPER_KEYS = "Hello1$$ WO11rld";
    private static final String CHAR_WITH_DIGITS_AND_SYMBOLS_LOWER_KEYS = "hello1$$ wo11rld";
    private static final String CHARS_WITH_UPPER_KEYS = "Hello WOrld!";
    private static final String CHARS_WITH_LOWER_KEYS = "hello world!";
    private Calculator calculator;

    @BeforeEach
    private void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void countCharsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.fillMap(EMPTY);
        });
        String actual = exception.getMessage();
        assertEquals(CHARS_NULL_OR_EMPTY, actual);
    }

    @Test
    public void countCharsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.fillMap(null);
        });
        String actual = exception.getMessage();
        assertEquals(CHARS_NULL_OR_EMPTY, actual);
    }

    @Test
    public void countCharsSWithUpperKeys() {
        Cash actual = calculator.fillMap(CHARS_WITH_UPPER_KEYS);
        Map<Character, Integer> cashMap = new HashMap<>();
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
    public void countCharsWithDigitsAndSymbols() {
        Cash actual = calculator.fillMap(CHAR_WITH_DIGITS_AND_SYMBOLS_UPPER_KEYS);
        Map<Character, Integer> cashMap = new HashMap<>();
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
    public void countCharsWithLowerKeys() {
        Cash actual = calculator.fillMap(CHARS_WITH_LOWER_KEYS);
        Map<Character, Integer> cashMap = new HashMap<>();
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
    public void countCharsTwoTimesWithDifferentInput() {
        calculator.fillMap(CHAR_WITH_DIGITS_AND_SYMBOLS_LOWER_KEYS);
        Cash actual = calculator.fillMap(CHARS_WITH_LOWER_KEYS);
        Map<Character, Integer> cashMap = new HashMap<>();
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
