package com.TestNgFreamwork.tests;

import com.TestNgFreamwork.pages.AmazonPage;
import com.TestNgFreamwork.utilities.ConfigurationReader;
import com.TestNgFreamwork.utilities.Driver;
import com.TestNgFreamwork.utilities.ReusableMothods;
import org.openqa.selenium.By;
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

        String puan="";
        String title = "";
        String price = "";
        String sayi="";
        int account = 0;
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

       // for (WebElement priceList : page.priceList){
         //   System.out.println(priceList.getText());
        //}

        //for (WebElement allReviews : page.allReviews){
          //  System.out.println(allReviews.getText());
        //}

        //BURADA getText() yerine getAttiribute kullanma nedenimiz herhangi bir yıldızla ilgili metin olmadığı için biz buna attributen ulaştık
        //for (WebElement allPoints : page.allPoint){
          //  System.out.println(allPoints.getAttribute("aria-label"));
        //}

        for (WebElement allProduct : page.allProducts) {
            //System.out.println(allProducts.getText());
            WebElement productTitle = allProduct.findElement(By.cssSelector(".a-size-base-plus.a-spacing-none.a-color-base.a-text-normal"));
           // System.out.println("İsim:" + productTitle.getText());

            WebElement productReview = allProduct.findElement(By.cssSelector(".a-size-base.s-underline-text"));
            //System.out.println("Değerlendirme:" + productReview.getText());

            WebElement allPoint = allProduct.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']"));
            System.out.println("Puan: " + allPoint.getAttribute("aria-label"));

            //ürün bilgilerinin içindeki fiyat bilgisini almak istersek yani element içinde element bilgisini almak için findElement kullanırız
            WebElement productPrice = allProduct.findElement(By.xpath("//span[@class='a-price-whole']"));
            //System.out.println("Fiyat: " + productPrice.getText()+" ₺");

            String[] puanEldeEt = allPoint.getAttribute("aria-label").split("üzerinden");

            //String[] puanEldeEt=allPoint.getAttribute("aria-label").split("üzerinden");
            int puanHesapla = (int) Float.parseFloat(puanEldeEt[0]) * Integer.parseInt((productReview.getText().replace(",","")));
            int fiyatHesapla = Integer.parseInt(productPrice.getText()) * 300;
            int result = puanHesapla - fiyatHesapla;

            if(result>account) {
                puan = allPoint.getAttribute("aria-label");
                title = productTitle.getText();
                price = productPrice.getText();
                sayi = productReview.getText();
            }
        }

        System.out.println(puan);
        System.out.println(title);
        System.out.println(price);
        System.out.println(sayi);
        Driver.closeDriver();
    }
}
//span[class='a-declarative']//a//i