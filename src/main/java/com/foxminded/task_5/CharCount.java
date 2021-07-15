package com.foxminded.task_5;

public class CharCount {
    private Calculator calculator;
    private Formatter formatter;
    private Cash cash;

    public CharCount(Calculator calculator, Formatter formatter) {
        this.calculator = calculator;
        this.formatter = formatter;
    }

    public String buildString(String word) {
        if (cash != null && cash.getCashWord().equals(word)) {
            return formatter.charFormatter(cash);
        }
        cash = calculator.fillMap(word);
        return formatter.charFormatter(cash);
    }

    public Cash getCash() {
        return cash;
    }
}
