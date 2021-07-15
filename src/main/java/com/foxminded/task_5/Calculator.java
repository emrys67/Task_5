package com.foxminded.task_5;

import java.util.HashMap;
import java.util.Locale;

public class Calculator {
    public Cash fillMap(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Null input is not allowed");
        }
        HashMap<Character, Integer> cashMap = new HashMap<>();
        word = word.toLowerCase(Locale.ROOT);
        for (var i = 0; i < word.length(); i++) {
            if (cashMap.containsKey(word.charAt(i))) {
                cashMap.put(word.charAt(i), cashMap.get(word.charAt(i)) + 1);
            } else {
                cashMap.put(word.charAt(i), 1);
            }
        }
        return new Cash(cashMap, word);
    }
}
