package com.TestNgFreamwork.utilities;

public class ReusableMothods {

    //burada sıklıkla kullanacağımız methodları yazabiliriz mesele çerezleri kabul et thread vs gibi.
    public static void sleep(int miliseconds) throws InterruptedException {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
