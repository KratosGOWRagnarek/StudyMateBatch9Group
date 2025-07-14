package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {

    public static void selectBy(WebElement location, String attributeValue, String method) {
        Select select = new Select(location);
        method = method.toLowerCase();

        switch (method) {

            case "text":
                select.selectByVisibleText(attributeValue);
                break;

            case "value":
                select.selectByValue(attributeValue);
                break;

            case "index":
                select.selectByIndex(Integer.parseInt(attributeValue));
                break;

            default:
                Assert.fail("The methodName that you provided is not one of the text, value, index");// it makes your execution fail no matter what
        }
    }

    public static void clickJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void sendKeysJS(WebDriver driver, WebElement element, String keys) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '" + keys + "';", element);
    }


    public static void scrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }


    public static void switchWindow(WebDriver driver, String title) {

        Set<String> pageIds = driver.getWindowHandles();

        for (String id : pageIds) {
            driver.switchTo().window(id); //no matter what switch your window
            if (driver.getTitle().contains(title)) {
                break;
            }
        }

    }


    public void getText(WebElement header) {

    }


    public static void getScreenShotCucumber(WebDriver driver, Scenario scenario) {
        Date currentDate = new Date();
        String screenShotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
        if (scenario.isFailed()) {
            //If scenario fails, get a screenshot
            File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //gets the screenshot and store it under our project
            try {
                FileUtils.copyFile(screenShotFile, new File("src/test/java/screenshot/" + screenShotFileName + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}


