package com.sensidev.utils;

import com.sensidev.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PageLoader extends BasePage {

    public PageLoader(WebDriver driver) {
        super(driver);
    }

    @Step("Load URL")
    public static void loadSensidevHomePage(WebDriver driver) throws InterruptedException {
        driver.navigate().to(sensidev_baseURL);
        Thread.sleep(10000);
        jsWaitForPageToLoad(5, driver);
    }

    @Step("Load URL")
    public static void loadTechlisticPage(WebDriver driver) throws InterruptedException {
        driver.navigate().to(techlistic_baseURL);
        Thread.sleep(10000);
        jsWaitForPageToLoad(5, driver);
    }

    @Step("Load URL")
    public static void loadURL(WebDriver driver, String uRL) {
        driver.navigate().to(uRL);
        jsWaitForPageToLoad(5, driver);
    }
}
