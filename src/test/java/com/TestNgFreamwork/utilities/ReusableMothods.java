package com.TestNgFreamwork.utilities;

public class ReusableMothods {

    public static void sleep(int miliseconds) throws InterruptedException {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
