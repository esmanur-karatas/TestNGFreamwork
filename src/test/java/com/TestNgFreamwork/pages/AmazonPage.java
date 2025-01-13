package com.TestNgFreamwork.pages;

import com.TestNgFreamwork.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPage {

    //burada genel bir amazon sayfası oluşturduk ama bunu aslında atıyorum amazon login ya da amazon header
    // amazon footer vs gibi parçalayarak bölmemiz lazım normalde özellikle her saftada fix kullanılan yerler var
    // mesela header footer navbar arama yerleri vs vs gibi bunların her biri için ayrı page açılabilir

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    //bu şekilde burdada bu yapıyı tanımlayarak test sayfasında kullanabiliriz.
   public void setSearchBox(String search) {
       searchBox.sendKeys(search, Keys.ENTER);


   }

   @FindBy (id = "searchDropdownBox")
    public WebElement searchDropdownBoxList;

    @FindBy(id = "sp-cc-rejectall-link")
    public WebElement cookie;

    @FindBy (className = "a-price-whole")
    public List<WebElement> priceList;

    //@FindBy(css = ".a-section.a-spacing-none.a-spacing-top-micro .a-row.a-size-small")
    //public WebElement allReviews;


    //@FindBy(xpath = "//a[@class='a-popover-trigger a-declarative']")
    //public WebElement allPoint;

    @FindBy (css = "[data-component-type=\"s-search-result\"]")
    public List<WebElement> allProducts;
}
