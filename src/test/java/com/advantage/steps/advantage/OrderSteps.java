package com.advantage.steps.advantage;

import com.advantage.pages.HeadPhonePage;
import com.advantage.pages.OrderPaymentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OrderSteps {
    private final HeadPhonePage headPhonePage = new HeadPhonePage();
    private final OrderPaymentPage orderPaymentPage = new OrderPaymentPage();

    @Then("I add {string} to cart")
    public void iAddToCart(String product) {
        if (product.equalsIgnoreCase("headPhones")) {
            headPhonePage.selectHeadPhone();
        }
    }

    @And("I complete purchase")
    public void iCompletePurchase() {
        orderPaymentPage.completePurchase();
    }
}
