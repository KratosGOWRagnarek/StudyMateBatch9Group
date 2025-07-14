package com.qa.studymate.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    protected void waitUntilTextPresent(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void waitUntilTextNotPresent(WebElement element, String text) {
        wait.until(driver -> !element.getText().contains(text));
    }
}
