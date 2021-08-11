package com.advantage.pages;

import com.advantage.helpers.CommonActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HeadPhonePage extends CommonActions {
    public HeadPhonePage() {
        PageFactory.initElements(driver, this);
    }

    private final Logger LOG = LogManager.getLogger(RegistrationPage.class);

    @FindBy(id = "headphonesImg")
    private WebElement headPhoneImg;

    @FindBy(css = ".productName")
    private List<WebElement> headPhonesList;

    @FindBy(name = "save_to_cart")
    private WebElement addToCardBtn;

    @FindBy(css = "#Description h1")
    private WebElement descriptionHeader;

    @FindBy(id = "product")
    private WebElement addedItemsCart;

    @FindBy(id = "menuCart")
    private WebElement cart;
    public void selectHeadPhone() {
        Assert.assertTrue(isElementClickable(5, headPhoneImg));
        headPhoneImg.click();
        Assert.assertTrue(isElementDisappeared(5, headPhoneImg));
        Assert.assertEquals(driver.getCurrentUrl(), "https://advantageonlineshopping.com/#/category/Headphones/2");
        Assert.assertTrue(isElementClickable(5, headPhonesList.get(3)));
        for (WebElement headPhone : headPhonesList) {
            LOG.info(headPhone.getText());
            {
                if (headPhone.getText().equalsIgnoreCase("Logitech USB Headset H390")) {
                    headPhone.click();
                    break;
                }
            }
        }

        Assert.assertTrue(isElementClickable(5,addToCardBtn));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://advantageonlineshopping.com/#/product/14"));
        Assert.assertTrue(isElementDisplay(5,descriptionHeader));
        Assert.assertTrue(descriptionHeader.getText().equalsIgnoreCase("Logitech USB Headset H390"));
        addToCardBtn.click();
        Assert.assertTrue(isElementDisplay(5,addedItemsCart));
        Assert.assertTrue(isElementClickable(5,cart));
        cart.click();
    }

}
