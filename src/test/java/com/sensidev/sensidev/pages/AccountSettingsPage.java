package com.sensidev.sensidev.pages;

import com.sensidev.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AccountSettingsPage extends BasePage {

    @FindBy(css = "#email")
    private WebElement emailField;

    public AccountSettingsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify Account settings page is displayed")
    public void verifyAccountSettingsPageIsDisplayed() {
        waitForURL("https://app.sensix.xyz/demo1/account", driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Step("Verify email is displayed and inactive")
    public void verifyEmailFieldIsInactiveAndDisplayed() {
        waitUntilVisible(emailField);
        Assert.assertEquals(emailField.getAttribute("aria-disabled"), "true", "button is not disabled");
        Assert.assertEquals(emailField.getAttribute("value"), sensidev_userName, "email is not the expected");
    }
}
