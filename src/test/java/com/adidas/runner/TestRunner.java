package com.adidas.runner;


import cucumber.api.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;



/**
 * Created by Usuario on 19/05/2017.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"features/approval_workflow_disabled/Sample1.feature"},
    plugin = {"pretty", "html:target/cucumber", "junit:target/junit-results.xml", "json:target/cucumber-report.json"},
    glue = {"com.adidas.serenity.steps"},
    tags = "not @ignore"
)
@Slf4j
public class TestRunner {

  private TestRunner () {

  }
}
