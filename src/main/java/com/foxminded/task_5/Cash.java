package com.foxminded.task_5;

import java.util.Map;
import java.util.Objects;

public class Cash {
    private final Map<Character, Integer> cashMap;
    private final String cashWord;

    public Cash(Map<Character, Integer> cashMap, String cashWord) {
        this.cashMap = cashMap;
        this.cashWord = cashWord;
    }

    public Map<Character, Integer> getCashMap() {
        return cashMap;
    }

    public String getCashWord() {
        return cashWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return cashMap.equals(cash.cashMap) && cashWord.equals(cash.cashWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cashMap, cashWord);
    }
}
