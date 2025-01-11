package com.TestNgFreamwork.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            //properties dosyasının içerisindeki "browser" anahtarının değerini getiricek
            //yani içinde chrome varsa chrome'u firefox edge ya da opera artık ne varsa o değeri getiricek.
            String browser = ConfigurationReader.getProperty("browser");

            //switch case ile browser içindeki değerlere göre hangi tarayıcının çalışacağını yazdırıyoruz.
            //ie => Internet expolorer demek yani kısaltmışlar
            //safarinin de kullanımı farkındaysan diğerlerinden farklı onun webDriverı böyle çağrılıyor
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
            }

        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null; //driverı kapattıktan sonra hafızadan temizle
        }

    }
}
