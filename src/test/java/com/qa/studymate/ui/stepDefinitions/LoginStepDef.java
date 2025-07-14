package com.qa.studymate.ui.stepDefinitions;
import com.qa.studymate.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import static utils.Driver.driver;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage(driver);

    @Given("user enters valid credentials and user clicks on login button")
    public void user_enters_valid_credentials_and_user_clicks_on_login_button() {
        loginPage.login("admin@codewise.com","codewise_123");
    }
}
