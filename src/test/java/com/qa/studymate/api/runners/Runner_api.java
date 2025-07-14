package com.qa.studymate.api.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/apiFeatures",
        glue = "com.qa.studymate.api.tests",
        dryRun = false,
        tags = "@regression",
        plugin={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)


public class Runner_api {
}