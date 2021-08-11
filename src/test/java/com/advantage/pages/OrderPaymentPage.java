package com.advantage.pages;

import com.advantage.helpers.CommonActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPaymentPage extends CommonActions {
    public OrderPaymentPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkOutButton")
    private WebElement checkOutBtn;

    @FindBy(id = "next_btn")
    private WebElement nextBtn;

    @FindBy(css = ".imgRadioButton:nth-child(2)")
    private WebElement masterCcRadioBtn;

    @FindBy(id = "creditCard")
    private WebElement creditCardNumberInput;

    @FindBy(name = "cvv_number")
    private WebElement cVVNumberInput;

    @FindBy(name = "cardholder_name")
    private WebElement cardHolderNameInput;

    @FindBy(id = "pay_now_btn_ManualPayment")
    private WebElement payNowBtn;

    @FindBy(id = "orderPaymentSuccess")
    private WebElement paymentSuccessPage;

    @FindBy(css = "#orderPaymentSuccess h2 span")
    private WebElement orderSuccessMsg;

    public void completePurchase() {
        Assert.assertTrue(isElementClickable(5, checkOutBtn));
        checkOutBtn.click();
        Assert.assertTrue(isElementClickable(5, nextBtn));
        nextBtn.click();
        Assert.assertTrue(isElementDisplay(5, masterCcRadioBtn));
        Assert.assertTrue(isElementClickable(5, masterCcRadioBtn));
        Assert.assertEquals(driver.getCurrentUrl(), "https://advantageonlineshopping.com/#/orderPayment");
        masterCcRadioBtn.click();
        Assert.assertTrue(isElementDisplay(5, creditCardNumberInput));
        Assert.assertTrue(isElementDisplay(5, cVVNumberInput));
        Assert.assertTrue(isElementDisplay(5, cardHolderNameInput));
        cardHolderNameInput.sendKeys(firstName + " " + lastName);

        cVVNumberInput.click();
        cVVNumberInput.clear();
        cVVNumberInput.sendKeys("345");
        creditCardNumberInput.sendKeys("5555 5555 5555");
        creditCardNumberInput.sendKeys(Keys.TAB);
        Assert.assertTrue(isElementClickable(5, payNowBtn));
        payNowBtn.click();
        Assert.assertTrue(isElementDisappeared(5, payNowBtn));
        Assert.assertTrue(isElementDisplay(5, paymentSuccessPage));
        Assert.assertTrue(isElementDisplay(5, orderSuccessMsg));
        Assert.assertEquals(orderSuccessMsg.getText(), "Thank you for buying with Advantage");
    }
}
