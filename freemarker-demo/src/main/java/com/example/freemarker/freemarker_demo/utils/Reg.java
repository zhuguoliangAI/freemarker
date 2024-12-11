package com.example.freemarker.freemarker_demo.utils;

public class Reg {
    public static void main(String[] args) {
        System.out.println(reg("aaaa"));
    }

    public static boolean reg(String input) {
        String regex = "^[a-zA-Z0-9_]+$";
        return input.matches(regex);
    }
}
