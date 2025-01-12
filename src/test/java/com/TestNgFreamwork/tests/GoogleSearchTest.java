package com.TestNgFreamwork.tests;

import com.TestNgFreamwork.utilities.Driver;
import com.TestNgFreamwork.utilities.ReusableMothods;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.TestNgFreamwork.utilities.ReusableMothods.sleep;

public class GoogleSearchTest {

    @Test
    public void testGoogleSearch() throws InterruptedException {

        Driver.getDriver().get("https://www.amazon.com.tr"); //driver sınıfında oluşturduğumuz getDriver metoduyla tarayıcıyı başlattık.


        //Gittiğimiz sayfanın başlığını aldık
        // String title = Driver.getDriver().getTitle();
        //System.out.println(title);

        //amazona navigate ile git
        //Driver.getDriver().navigate().to("https://www.amazon.com.tr/");
        //ReusableMothods.sleep(1000);

        //bir önceki sayfaya geri dön
        //Driver.getDriver().navigate().back();
        //ReusableMothods.sleep(1000);

        //geri döndüğün sayfaya git
        //Driver.getDriver().navigate().forward();
        //ReusableMothods.sleep(1000);

        //sayfayı yenile
        //Driver.getDriver().navigate().refresh();


        //işlemler çok hızlı olduğu için 5 saniye beklemek istedik onun içinde her seferinde ayrı ayrı try catch içinde
        //Thread sleep metosunu kullanmak yerine bir tane sınıf oluşturup onun içinde tanumladık
        // sınıfın adı ReusableMethods methodun adı da sleep be int bir değer alıyor
        //ReusableMothods.sleep(4000);
        //Driver.closeDriver();
    }
}
