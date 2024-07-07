package com.ecommerce.testing.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/ecommerce/testing/features",
    glue = "com.ecommerce.testing.steps",
    plugin = {
        "pretty", 
        "html:target/cucumber-reports.html",
        "json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml"
    },
    monochrome = true,
    dryRun = false
)
public class TestRunner {
}

