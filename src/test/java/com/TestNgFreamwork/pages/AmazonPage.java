package com.TestNgFreamwork.pages;

import com.TestNgFreamwork.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    //burada genel bir amazon sayfası oluşturduk ama bunu aslında atıyorum amazon login ya da amazon header
    // amazon footer vs gibi parçalayarak bölmemiz lazım normalde özellikle her saftada fix kullanılan yerler var
    // mesela header footer navbar arama yerleri vs vs gibi bunların her biri için ayrı page açılabilir

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

   public void setSearchBox(String search) {
       searchBox.sendKeys();
   }

}
