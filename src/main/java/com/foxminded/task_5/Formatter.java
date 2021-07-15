package com.foxminded.task_5;

public class Formatter {
    private static final String QUOTE = "\"";
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String NEW_LINE = "\n";

    public String charFormatter(Cash cash) {
        var wordOut = new StringBuilder();
        var buffer = "";
        for (var i = 0; i < cash.getCashWord().length(); i++) {
            if (!buffer.contains(String.valueOf(cash.getCashWord().charAt(i)))) {
                buffer += cash.getCashWord().charAt(i);
            }
        }
        for (var i = 0; i < buffer.length(); i++) {
            wordOut.append(QUOTE + buffer.charAt(i));
            wordOut.append(QUOTE + SPACE + DASH + SPACE);
            wordOut.append(cash.getCashMap().get(buffer.charAt(i)) + NEW_LINE);
        }
        return wordOut.toString();
    }

}
