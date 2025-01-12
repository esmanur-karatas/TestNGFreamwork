package com.TestNgFreamwork.tests;

import com.TestNgFreamwork.pages.AmazonPage;
import com.TestNgFreamwork.utilities.ConfigurationReader;
import com.TestNgFreamwork.utilities.Driver;
import com.TestNgFreamwork.utilities.ReusableMothods;
import org.testng.annotations.Test;

import java.util.Properties;

public class AmazonSearchTest {
    //Amazon page nesnesi oluşturduk
    AmazonPage page = new AmazonPage();

    //properties dosyasındaki web addressi çağırdık
    String url = ConfigurationReader.getProperty("address");
    @Test
    public void testSearch() {
        Driver.getDriver().get(url);
        page.searchBox.sendKeys("Kulaklık");

        Driver.closeDriver();
    }
}
