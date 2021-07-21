package com.foxminded.task_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CharCounterTest {
    private final static String INPUT_WORD_UPPER_KEYS = "HELL";
    private final static String INPUT_WORD_LOWER_KEYS = "hell";
    @Mock
    Calculator calculator;
    private CharCounter charCounter;
    private Formatter formatter;
    private Cash cashLower;
    private Cash cashUpper;
    private Map<Character, Integer> cashMap;

    @BeforeEach
    private void setUp() {
        cashMap = new HashMap<>();
        cashMap.put('h', 1);
        cashMap.put('e', 1);
        cashMap.put('l', 2);
        cashLower = new Cash(cashMap, INPUT_WORD_LOWER_KEYS);
        cashMap.clear();
        cashMap.put('H', 1);
        cashMap.put('E', 1);
        cashMap.put('L', 2);
        cashUpper = new Cash(cashMap, INPUT_WORD_UPPER_KEYS);
        formatter = new Formatter();
        charCounter = new CharCounter(calculator, formatter);
    }

    @Test
    public void cashReturnedIfSimilarInput() {
        when(calculator.fillMap(INPUT_WORD_LOWER_KEYS)).thenReturn(cashLower);
        charCounter.buildString(INPUT_WORD_LOWER_KEYS);
        charCounter.buildString(INPUT_WORD_LOWER_KEYS);
        verify(calculator, times(1)).fillMap(INPUT_WORD_LOWER_KEYS);
    }

    @Test
    public void cashNotReturnedIfSimilarInputLowerAndUpperKeys() {
        when(calculator.fillMap(INPUT_WORD_LOWER_KEYS)).thenReturn(cashLower);
        when(calculator.fillMap(INPUT_WORD_UPPER_KEYS)).thenReturn(cashUpper);
        charCounter.buildString(INPUT_WORD_LOWER_KEYS);
        charCounter.buildString(INPUT_WORD_UPPER_KEYS);
        verify(calculator, times(1)).fillMap(INPUT_WORD_LOWER_KEYS);
        verify(calculator, times(1)).fillMap(INPUT_WORD_UPPER_KEYS);
    }
}
