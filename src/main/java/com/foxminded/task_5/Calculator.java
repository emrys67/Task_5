package com.foxminded.task_5;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static final String ARGUMENT_EXCEPTION_TEXT = "Null and empty input is not allowed";

    public Cash fillMap(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException(ARGUMENT_EXCEPTION_TEXT);
        }
        Map<Character, Integer> cashMap = new HashMap<>();
        String cashWord = word;
        word = word.toLowerCase();
        for (var i = 0; i < word.length(); i++) {
            if (cashMap.containsKey(word.charAt(i))) {
                cashMap.put(word.charAt(i), cashMap.get(word.charAt(i)) + 1);
            } else {
                cashMap.put(word.charAt(i), 1);
            }
        }
        return new Cash(cashMap, cashWord);
    }
}
