package com.advantage.steps.advantage;

import com.advantage.helpers.CommonActions;
import com.advantage.pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class RegistrationSteps extends CommonActions {
    private final RegistrationPage registrationPage = new RegistrationPage();


    @Then("I navigate to create account page")
    public void iNavigateToCreateAccountPage() {
        registrationPage.navigateToCreateAccountPage();
    }

    @And("I register new user")
    public void iRegisterNewUser() {
        registrationPage.createAccount();
    }
}
