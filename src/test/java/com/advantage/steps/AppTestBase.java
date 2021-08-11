package com.advantage.steps;

import com.advantage.helpers.CommonActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppTestBase extends CommonActions {
    private static boolean scenarioResult;

    private static final Logger LOG = LogManager.getLogger(AppTestBase.class);

    @Before
    public void startApp(Scenario scenario) throws MalformedURLException {
        LOG.info("***********************************************************");
        LOG.info("** Starting New TestCase -> " + scenario.getName() + "  **");
        LOG.info("***********************************************************");
        scenario.getSourceTagNames().forEach(System.out::println);

        browserName = System.getProperty("browser");

            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-blink-features");
                chromeOptions.addArguments("--disable-app-list-dismiss-on-blur");
                chromeOptions.addArguments("--disable-core-animation-plugins");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                chromeOptions.addArguments("start-fullscreen");
                driver = new ChromeDriver(chromeOptions);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "target/logs.txt");
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
            } else if (browserName.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
            }
        }


    @After
    public void closeApp(Scenario scenario) {
        byte[] screenshot;
        if (scenario.isFailed()) {
            try {
                LOG.info("Failed scenario ----->> " + scenario.getSourceTagNames());
                LOG.info("Browser failed on " + browserName);
                LOG.info(("Failed scenario ----->> " + scenario.getStatus()));
                LOG.info("Browser failed on " + browserName);
                screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Test failed on : " + browserName);
            } catch (WebDriverException screenShot) {
                System.err.println(screenShot
                        .getMessage());
            }
        }
        if (driver != null) {
            driver.close();
        }
    }
}
