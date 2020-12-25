package com.geek;

interface IMarkUp {

    void markUp(String msg);

}

/**
 * @author geek
 */
public class App {
    public static void main(String[] args) {
        IMarkUp imarkUp = (message) -> System.out.println(message);
        imarkUp.markUp("lambda!");
    }

}
