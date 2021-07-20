package com.foxminded.task_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormatterTest {
    private static final String CHARS_WITH_DIGITS_AND_SYMBOLS = """
            Hello1$$ WO1211)rld!
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
            Hello WOrld!
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
            hello world!
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
    private static final String WORD_WITH_DIGITS_AND_SYMBOLS = "Hello1$$ WO1211)rld!";
    private static final String WORD_WITH_UPPER_KEYS = "Hello WOrld!";
    private static final String WORD_WITH_LOWER_KEYS = "hello world!";
    private static final String CHARS_NULL_OR_EMPTY = "Null input is not allowed";
    private static final String EMPTY = "";
    private Formatter formatter;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        formatter = new Formatter();
        calculator = new Calculator();

    }

    @Test
    void countCharsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            formatter.charFormatter(calculator.fillMap(EMPTY));
        });
        String actual = exception.getMessage();
        assertEquals(CHARS_NULL_OR_EMPTY, actual);
    }

    @Test
    void countCharsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            formatter.charFormatter(calculator.fillMap(null));
        });
        String actual = exception.getMessage();
        assertEquals(CHARS_NULL_OR_EMPTY, actual);
    }

    @Test
    void countCharsSWithUpperKeys() {
        Cash cash = calculator.fillMap(WORD_WITH_UPPER_KEYS);
        String actual = formatter.charFormatter(cash);
        assertEquals(COUNT_CHARS_WITH_UPPER_KEYS, actual);
    }

    @Test
    void countCharsWithDigitsAndSymbols() {
        Cash cash = calculator.fillMap(WORD_WITH_DIGITS_AND_SYMBOLS);
        String actual = formatter.charFormatter(cash);
        assertEquals(CHARS_WITH_DIGITS_AND_SYMBOLS, actual);
    }

    @Test
    void countCharsWithLowerKeys() {
        Cash cash = calculator.fillMap(WORD_WITH_LOWER_KEYS);
        String actual = formatter.charFormatter(cash);
        assertEquals(COUNT_CHARS_WITH_LOWER_KEYS, actual);
    }

    @Test
    void countCharsTwoTimesWithDifferentInput() {
        calculator.fillMap(WORD_WITH_LOWER_KEYS);
        Cash cash = calculator.fillMap(WORD_WITH_DIGITS_AND_SYMBOLS);
        String actual = formatter.charFormatter(cash);
        assertEquals(CHARS_WITH_DIGITS_AND_SYMBOLS, actual);
    }
}
