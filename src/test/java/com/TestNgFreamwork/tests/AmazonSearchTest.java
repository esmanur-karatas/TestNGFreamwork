package com.TestNgFreamwork.tests;

import com.TestNgFreamwork.pages.AmazonPage;
import com.TestNgFreamwork.utilities.ConfigurationReader;
import com.TestNgFreamwork.utilities.Driver;
import com.TestNgFreamwork.utilities.ReusableMothods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
        //burda kullandığımız bu sendkeys i page sayfasında da method olarak kullanıp burada sadece çağırabiliriz.
        //page.searchBox.sendKeys("Kulaklık");
        //örnek olarak:
        //page.setSearchBox("Kulaklık");

        //dropdowndaki tüm kategorileri alıp içinden seçim yapmak için select kullanabiliriz
        Select select = new Select(page.searchDropdownBoxList);
        //ya bu şekilde kategorinin ismini yazarak seçim yapabiliriz
        //select.selectByVisibleText("Elektronik");

        //ya da aşağıdaki gibi index numarasıyla bir seçim yapabiliriz.
        select.selectByIndex(5);

        //ya da incelediğimiz kodların içindeki kategorinin value ismini de alabiliriz
        //select.selectByValue("search-alias=electronics");

        page.setSearchBox("Akıllı Telefon");

        page.cookie.click();

        for (WebElement priceList : page.priceList){
            System.out.println(priceList.getText());
        }

        for (WebElement allReviews : page.allReviews){
            System.out.println(allReviews.getText());
        }
        Driver.closeDriver();
    }
}
