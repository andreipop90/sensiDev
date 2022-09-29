package com.sensidev.base;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static io.qameta.allure.Allure.step;

public class BasePage {

    public static String sensidev_baseURL;
    public static String sensidev_userName;
    public static String sensidev_password;
    public static String techlistic_baseURL;
    public static String wikiEN_baseURL;
    public static String wikiDE_baseURL;

    public WebDriver driver;

    public static WebDriver webDriver;

    private static final int WAIT_TIME_OUT_IN_SECONDS = 5;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        loadElements();
    }

    public void loadElements() {
        PageFactory.initElements(driver, this);
    }

    public void waitUntilVisible(WebElement element) {
        try {
            new WebDriverWait(driver, WAIT_TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillTextField(WebElement textField, String textFieldName, String textFieldValue) {
        step("Fill text field: \"" + textFieldName + "\" with value: \"" + textFieldValue + "\"");
        waitUntilVisible(textField);
        try {
            textField.click();
        } catch (Exception e) {
        }

        textField.clear();
        textField.sendKeys(textFieldValue);
    }

    public void clickElement(WebElement element, String elementName) {
        step("Click element : \"" + elementName + "\"");

        waitUntilVisible(element);
        waitUntilClickable(element);

        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("<" + elementName + "> is not present or clickable" +
                    "\n\n" + e.getMessage().toString().split("\n")[0]);
        }
    }

    public static void jsWaitForPageToLoad(int timeOutInSeconds, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jsCommand = "return document.readyState";

        // Validate readyState before doing any waits
        if (js.executeScript(jsCommand).toString().equals("complete")) {
            return;
        }

        for (int i = 0; i < timeOutInSeconds; i++) {
            if (js.executeScript(jsCommand).toString().equals("complete")) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }

    public static void waitForURL(String url, WebDriver driver) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe(url));
    }

    public void waitUntilClickable(WebElement element) {
        try {
            new WebDriverWait(driver, WAIT_TIME_OUT_IN_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Scroll element into view")
    public void scrollIntoView(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (WebDriverException ex) {
        }
    }
}
