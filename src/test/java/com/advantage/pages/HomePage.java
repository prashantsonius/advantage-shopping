package com.advantage.pages;

import com.advantage.helpers.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends CommonActions {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#our_products [id*='Img'] ")
    private List<WebElement> productImagesList;

    @FindBy(css = "[ng-show='welcome']")
    private WebElement header;

    @FindBy(id = "headphonesImg")
    private WebElement headPhoneImg;

    public void verifyHomePage() {
        Assert.assertTrue(isElementDisplay(5, header));
        Assert.assertEquals(driver.getTitle(), " Advantage Shopping");
        Assert.assertTrue(isElementDisplay(5, headPhoneImg));
        Assert.assertEquals(productImagesList.size(), 5);
    }
}
