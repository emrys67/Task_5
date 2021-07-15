package com.foxminded.task_5;

import java.util.HashMap;
import java.util.Locale;

public class CharCounter {
    private HashMap<Character, Integer> cashMap;
    private String cashWord;
    private boolean wordRepeated;
    private static final String QUOTE = "\"";
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String NEW_LINE = "\n";

    public String countChar(String word) {
        fillMap(word);
        return charFormatter();
    }

    private void fillMap(String word) {
        wordRepeated = false;
        checkIfWordRepeated(word);
        if (wordRepeated) {
            return;
        }
        if (word == null) {
            throw new IllegalArgumentException("Null input is not allowed");
        }
        cashMap = new HashMap<>();
        word = word.toLowerCase(Locale.ROOT);
        cashWord = word;
        for (var i = 0; i < word.length(); i++) {
            if (cashMap.containsKey(word.charAt(i))) {
                cashMap.put(word.charAt(i), cashMap.get(word.charAt(i)) + 1);
            } else {
                cashMap.put(word.charAt(i), 1);
            }
        }
    }

    private String charFormatter() {
        var wordOut = new StringBuilder();
        var buffer = "";
        for (var i = 0; i < cashWord.length(); i++) {
            if (!buffer.contains(String.valueOf(cashWord.charAt(i)))) {
                buffer += cashWord.charAt(i);
            }
        }
        for (var i = 0; i < buffer.length(); i++) {
            wordOut.append(QUOTE + buffer.charAt(i));
            wordOut.append(QUOTE + SPACE + DASH + SPACE);
            wordOut.append(cashMap.get(buffer.charAt(i)) + NEW_LINE);
        }
        return wordOut.toString();
    }

    private void checkIfWordRepeated(String word) {
        if (cashWord != null && cashWord.equalsIgnoreCase(word)) {
            wordRepeated = true;
        }
    }

    public boolean getWordRepeated() {
        return wordRepeated;
    }
}
