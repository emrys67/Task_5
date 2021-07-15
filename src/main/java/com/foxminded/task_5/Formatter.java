package com.foxminded.task_5;

import java.util.Locale;

public class Formatter {
    private static final String QUOTE = "\"";
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String NEW_LINE = "\n";

    public String charFormatter(Cash cash) {
        var wordOut = new StringBuilder();
        var buffer = "";
        String cashWord = cash.getCashWord().toLowerCase(Locale.ROOT);
        for (var i = 0; i < cashWord.length(); i++) {
            if (!buffer.contains(String.valueOf(cashWord.charAt(i)))) {
                buffer += cashWord.charAt(i);
            }
        }
        for (var i = 0; i < buffer.length(); i++) {
            wordOut.append(QUOTE + buffer.charAt(i));
            wordOut.append(QUOTE + SPACE + DASH + SPACE);
            wordOut.append(cash.getCashMap().get(buffer.charAt(i)) + NEW_LINE);
        }
        if (!cash.getCashWord().isEmpty()) {
            wordOut.insert(0, cash.getCashWord() + NEW_LINE);
        }
        return wordOut.toString();
    }

}
