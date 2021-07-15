package com.foxminded.task_5;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();
        CharCounter count = new CharCounter(calculator, formatter);
        System.out.println(count.buildString("Hello1$$ WO1211)rld!"));
    }
}
