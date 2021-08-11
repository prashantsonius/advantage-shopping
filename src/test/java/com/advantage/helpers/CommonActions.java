package com.advantage.helpers;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

public class CommonActions {
    protected static String browserName;
    public static WebDriver driver;
    protected static final Faker FAKER = new Faker(new Locale("en"));
    protected static String userName;
    protected static String firstName;
    protected static String lastName;
    protected static String email;
    protected static String password = new Random().ints(8, 33, 122).mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());

    protected boolean isElementDisplay(long timeInSeconds, WebElement displayElement) {
        try {
            Wait<WebDriver> wait1 = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeInSeconds))
                    .pollingEvery(Duration.ofMillis(10))
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(Exception.class);
            WebElement element = wait1.until(ExpectedConditions.visibilityOf(displayElement));
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementClickable(long timeInSeconds, WebElement displayElement) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeInSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(displayElement));
            return displayElement.isDisplayed() && displayElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    protected void selectValueFromDropDown(WebElement locator, String visibleText) {
        Select select = new Select(locator);
        select.selectByVisibleText(visibleText);
    }

    protected boolean isElementDisappeared(long timeInSeconds, WebElement displayElement) {
        try {
            Wait<WebDriver> wait1 = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeInSeconds))
                    .pollingEvery(Duration.ofSeconds(1));
            wait1.until(ExpectedConditions.invisibilityOf(displayElement));
            return true;
        } catch (NoSuchElementException | StaleElementReferenceException nse) {
            return true;
        } catch (TimeoutException te) {
            return false;
        }
    }
}
