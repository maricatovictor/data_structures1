package app;

import app.InfixToPostFix;

public class App {
    public static void main(String[] args) {
        System.out.println(InfixToPostFix.convertToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
}