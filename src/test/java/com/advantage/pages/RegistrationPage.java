package com.advantage.pages;

import com.advantage.helpers.CommonActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPage extends CommonActions {
    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    private final Logger LOG = LogManager.getLogger(RegistrationPage.class);

    @FindBy(id = "menuUserLink")
    private WebElement userLink;

    @FindBy(css = ".loginPopUpCloseBtn")
    private WebElement loginPopUpCloseBtn;

    @FindBy(css = ".login.ng-scope")
    private WebElement loginPopUp;

    @FindBy(css = "[translate='CREATE_NEW_ACCOUNT']")
    private WebElement createNewAccountLink;

    @FindBy(css = "#registerPage [translate='CREATE_ACCOUNT']")
    private WebElement createAccountHeader;

    @FindBy(id = "registerPage")
    private WebElement registerPage;

    @FindBy(name = "usernameRegisterPage")
    private WebElement userNameInput;

    @FindBy(name = "emailRegisterPage")
    private WebElement emailInput;

    @FindBy(name = "passwordRegisterPage")
    private WebElement passwordInput;

    @FindBy(name = "confirm_passwordRegisterPage")
    private WebElement confirmPasswordInput;

    @FindBy(name = "first_nameRegisterPage")
    private WebElement firstNameInput;

    @FindBy(name = "last_nameRegisterPage")
    private WebElement lastNameInput;

    @FindBy(name = "phone_numberRegisterPage")
    private WebElement phoneNoInput;

    @FindBy(name = "countryListboxRegisterPage")
    private WebElement countryList;

    @FindBy(name = "cityRegisterPage")
    private WebElement cityInput;

    @FindBy(name = "state_/_province_/_regionRegisterPage")
    private WebElement stateProvinceRegionInput;

    @FindBy(name = "addressRegisterPage")
    private WebElement addressInput;

    @FindBy(name = "postal_codeRegisterPage")
    private WebElement postalCodeInput;

    @FindBy(name = "allowOffersPromotion")
    private WebElement offersCheckBox;

    @FindBy(name = "i_agree")
    private WebElement iAgreeCheckBox;

    @FindBy(id = "register_btnundefined")
    private WebElement registerBtn;

    @FindBy(css = ".hi-user.containMiniTitle")
    private WebElement loggedInUser;

    public void navigateToCreateAccountPage() {
        Assert.assertTrue(isElementClickable(5, userLink));
        userLink.click();
        Assert.assertTrue(isElementDisplay(5, loginPopUpCloseBtn));
        Assert.assertTrue(isElementClickable(5, createNewAccountLink));
        createNewAccountLink.click();
        Assert.assertTrue(isElementDisappeared(5, createNewAccountLink));
        Assert.assertTrue(isElementDisappeared(5, loginPopUpCloseBtn));
    }

    public void createAccount() {
        Assert.assertTrue(isElementDisplay(5, createAccountHeader));
        Assert.assertTrue(isElementDisplay(5, registerPage));
        Assert.assertEquals(driver.getCurrentUrl(), "https://advantageonlineshopping.com/#/register");
        Assert.assertEquals(createAccountHeader.getText(), "CREATE ACCOUNT");
        Assert.assertTrue(isElementDisplay(5, userNameInput));
        Assert.assertTrue(isElementDisplay(5, emailInput));
        Assert.assertTrue(isElementDisplay(5, passwordInput));
        Assert.assertTrue(isElementDisplay(5, confirmPasswordInput));
        Assert.assertTrue(isElementDisplay(5, firstNameInput));
        Assert.assertTrue(isElementDisplay(5, lastNameInput));
        Assert.assertTrue(isElementDisplay(5, phoneNoInput));
        Assert.assertTrue(isElementDisplay(5, cityInput));
        Assert.assertTrue(isElementDisplay(5, addressInput));
        Assert.assertTrue(isElementDisplay(5, stateProvinceRegionInput));
        Assert.assertTrue(isElementDisplay(5, postalCodeInput));

        firstName = FAKER.name().firstName();
        lastName = FAKER.name().lastName();
        userName = firstName + FAKER.number().digits(2);
        email = firstName + "." + lastName + "@mailinator.com";
        password = password + "Aa1£";
        userNameInput.sendKeys(userName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        LOG.info("userName : " + userName);
        LOG.info("password : " + password);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        phoneNoInput.sendKeys(FAKER.phoneNumber().cellPhone());

        selectValueFromDropDown(countryList, "Tanzania");
        cityInput.sendKeys("Cairo");
        addressInput.sendKeys(FAKER.address().streetAddress());
        stateProvinceRegionInput.sendKeys(FAKER.address().stateAbbr());
        postalCodeInput.sendKeys(FAKER.address().zipCode());

        Assert.assertTrue(isElementClickable(5, offersCheckBox));
        Assert.assertTrue(isElementClickable(5, iAgreeCheckBox));
        offersCheckBox.click();
        iAgreeCheckBox.click();
        Assert.assertTrue(isElementClickable(5, registerBtn));
        try {
            registerBtn.click();
        }catch (UnhandledAlertException e){
            e.getAlertText();
        }

        Assert.assertTrue(isElementDisappeared(5, registerBtn));
        Assert.assertEquals(loggedInUser.getText(), (userName));
    }


}
