package com.foxminded.task_5;

import java.util.HashMap;

public class Calculator {
    private static final String ARGUMENT_EXCEPTION_TEXT = "Null input is not allowed";

    public Cash fillMap(String word) {
        if (word == null) {
            throw new IllegalArgumentException(ARGUMENT_EXCEPTION_TEXT);
        }
        HashMap<Character, Integer> cashMap = new HashMap<>();
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
