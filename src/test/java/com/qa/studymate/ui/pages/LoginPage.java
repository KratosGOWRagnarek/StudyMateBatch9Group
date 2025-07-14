package com.qa.studymate.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;

import static utils.Driver.driver;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@data-shrink='true']/../div//div")
    public WebElement languageDropdown;

    @FindBy(xpath = "//li[.='Русский']")
    public WebElement rusLanguage;

    @FindBy(xpath = "//li[.='English']")
    public WebElement engLanguage;

    @FindBy(css = "input[name='email']")
    public WebElement loginEmail;

    @FindBy(css = "input[name='password']")
    public WebElement loginPassword;

    @FindBy(css = "button[type=submit]")
    public WebElement loginButton;


    @FindBy(css = "div[class='MuiAlert-message css-1xsto0d']")
    public WebElement invalidCredentialsAlert;

    public void login(String email, String password) {
        this.loginEmail.sendKeys(email);
        this.loginPassword.sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        BrowserUtils.clickJS(driver, loginButton);

    }

}
