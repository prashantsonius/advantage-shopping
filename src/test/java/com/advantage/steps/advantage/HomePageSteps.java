package com.advantage.steps.advantage;

import com.advantage.helpers.CommonActions;
import com.advantage.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomePageSteps extends CommonActions {
    private final HomePage homePage = new HomePage();

    @Given("I open advantage shopping site")
    public void iOpenAdvantageShoppingSite() {
        driver.get("https://advantageonlineshopping.com/#/");
    }

    @And("I verify home page")
    public void iVerifyHomePage() {
        homePage.verifyHomePage();
    }
}
