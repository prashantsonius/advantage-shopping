package com.advantage.test;

import com.advantage.helpers.CucumberReports;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;


@CucumberOptions(features = "src/test/resources/features/",
        plugin = {"pretty", "html:target/cucumber-report",
                "json:target/cucumber-parallel/cucumber.json", "junit:target/cucumber.xml"},
        glue = {"com.advantage.steps"},
        publish = false,
        tags = "@completeSale and not @ignore")
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void reports() {
        CucumberReports.generateReports();
    }
}
