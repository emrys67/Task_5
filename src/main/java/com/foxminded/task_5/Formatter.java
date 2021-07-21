package com.foxminded.task_5;

import java.util.List;
import java.util.stream.Collectors;

public class Formatter {
    private static final String QUOTE = "\"";
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String NEW_LINE = "\n";

    public String charFormatter(Cash cash) {
        List<Character> list = getUniqueCharacters(cash);
        return buildString(cash, list);
    }

    private List<Character> getUniqueCharacters(Cash cash) {
        String cashWord = cash.getCashWord().toLowerCase();
        List<Character> word = cashWord.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        return word.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private String buildString(Cash cash, List<Character> list) {
        var wordOut = new StringBuilder();
        wordOut.append(cash.getCashWord() + NEW_LINE);
        list.stream()
                .forEach(symbol -> wordOut.append(QUOTE + symbol + QUOTE + SPACE + DASH + SPACE + cash.getCashMap().get(symbol) + NEW_LINE));
        return wordOut.toString();
    }

}
