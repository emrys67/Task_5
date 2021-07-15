package com.foxminded.task_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CharCounterTest {
    private final static String INPUT_WORD = "hell";
    private CharCounter charCounter;
    private Formatter formatter;
    private Cash cash;
    private HashMap<Character, Integer> cashMap;
    @Mock
    Calculator calculator;

    @BeforeEach
    void setUp() {
        cashMap = new HashMap<>();
        cashMap.put('h', 1);
        cashMap.put('e', 1);
        cashMap.put('l', 2);
        cash = new Cash(cashMap, INPUT_WORD);
        formatter = new Formatter();
        charCounter = new CharCounter(calculator, formatter);
    }

    @Test
    void cashReturnedIfSimilarInput() {
        when(calculator.fillMap(INPUT_WORD)).thenReturn(cash);
        charCounter.buildString(INPUT_WORD);
        charCounter.buildString(INPUT_WORD);
        verify(calculator, atMost(1)).fillMap(INPUT_WORD);
    }
}
