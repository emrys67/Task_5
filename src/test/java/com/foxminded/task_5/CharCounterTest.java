package com.foxminded.task_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharCounterTest {
    private CharCounter charCounter;
    private static final String CHAR_WITH_DIGITS_AND_SYMBOLS = """
            "h" - 1
            "e" - 1
            "l" - 3
            "o" - 2
            "1" - 4
            "$" - 2
            " " - 1
            "w" - 1
            "2" - 1
            ")" - 1
            "r" - 1
            "d" - 1
            "!" - 1
            """;
    private static final String COUNT_CHARS_WITH_UPPER_KEYS = """
            "h" - 1
            "e" - 1
            "l" - 3
            "o" - 2
            " " - 1
            "w" - 1
            "r" - 1
            "d" - 1
            "!" - 1
            """;
    private static final String COUNT_CHARS_WITH_LOWER_KEYS = """
            "h" - 1
            "e" - 1
            "l" - 3
            "o" - 2
            " " - 1
            "w" - 1
            "r" - 1
            "d" - 1
            "!" - 1
            """;
    private static final String CHARS_NULL = "Null input is not allowed";
    private static final String EMPTY = "";

    @BeforeEach
    void setUp() {
        charCounter = new CharCounter();
    }

    @Test
    void countCharsEmpty() {
        String actual = charCounter.countChar(EMPTY);
        assertEquals(EMPTY, actual);
    }

    @Test
    void countCharsSNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            charCounter.countChar(null);
        });
        String actual = exception.getMessage();
        assertEquals(CHARS_NULL, actual);
    }

    @Test
    void countCharsSWithUpperKeys() {
        String actual = charCounter.countChar("Hello WOrld!");
        assertEquals(COUNT_CHARS_WITH_UPPER_KEYS, actual);
    }

    @Test
    void inputEqualsPrivios() {
        charCounter.countChar("hello world!");
        charCounter.countChar("hello world!");
        assertTrue(charCounter.getWordRepeated());
    }

    @Test
    void countCharsWithDigitsAndSymbols() {
        String actual = charCounter.countChar("Hello1$$ WO1211)rld!");
        assertEquals(CHAR_WITH_DIGITS_AND_SYMBOLS, actual);
    }

    @Test
    void countCharsWithLowerKeys() {
        String actual = charCounter.countChar("hello world!");
        assertEquals(COUNT_CHARS_WITH_LOWER_KEYS, actual);
    }

    @Test
    void countCharsTwoTimesWithDifferentInput() {
        charCounter.countChar("hello world!");
        String actual = charCounter.countChar("Hello1$$ WO1211)rld!");
        assertEquals(CHAR_WITH_DIGITS_AND_SYMBOLS, actual);
    }
}
