package com.qa.studymate.ui.runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberReport.html", "json:target/cucumber/testReport.json"},
        features = "src/test/resources",
        glue = "src/test/java/com/qa/studymate/stepDefinitions",

        dryRun = false


)
public class Runner {
}
