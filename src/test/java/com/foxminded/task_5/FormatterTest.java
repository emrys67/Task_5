package com.foxminded.task_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormatterTest {
    private Formatter formatter;
    private Calculator calculator;
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
        formatter = new Formatter();
        calculator = new Calculator();

    }

    @Test
    void countCharsEmpty() {
        Cash cash = calculator.fillMap(EMPTY);
        String actual = formatter.charFormatter(cash);
        assertEquals(EMPTY, actual);
    }

    @Test
    void countCharsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            formatter.charFormatter(calculator.fillMap(null));
        });
        String actual = exception.getMessage();
        assertEquals(CHARS_NULL, actual);
    }

    @Test
    void countCharsSWithUpperKeys() {
        Cash cash = calculator.fillMap("Hello WOrld!");
        String actual = formatter.charFormatter(cash);
        assertEquals(COUNT_CHARS_WITH_UPPER_KEYS, actual);
    }

    @Test
    void countCharsWithDigitsAndSymbols() {
        Cash cash = calculator.fillMap("Hello1$$ WO1211)rld!");
        String actual = formatter.charFormatter(cash);
        assertEquals(CHAR_WITH_DIGITS_AND_SYMBOLS, actual);
    }

    @Test
    void countCharsWithLowerKeys() {
        Cash cash = calculator.fillMap("hello world!");
        String actual = formatter.charFormatter(cash);
        assertEquals(COUNT_CHARS_WITH_LOWER_KEYS, actual);
    }

    @Test
    void countCharsTwoTimesWithDifferentInput() {
        calculator.fillMap("hello world!");
        Cash cash = calculator.fillMap("Hello1$$ WO1211)rld!");
        String actual = formatter.charFormatter(cash);
        assertEquals(CHAR_WITH_DIGITS_AND_SYMBOLS, actual);
    }
}
