package com.sensidev.sensidev.pages;

import com.sensidev.base.BasePage;
import com.sensidev.data.CredentialsModel;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(css = "button[color='#ffffff'] > span")
    private WebElement defaultLoginBtn;

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "#password")
    private WebElement passwordField;
    @FindBy(css = "p[class^='Typographystyle__P']")
    private List<WebElement> loginErrorMessagesList;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify Login Page is displayed")
    public void verifyLoginPageIsDisplayed() {
        Assert.assertTrue(driver.getCurrentUrl().contains(BasePage.sensidev_baseURL), "Home Page is not displayed");
    }

    @Step("Click default login button")
    public void clickDefaultLoginBtn() {
        clickElement(defaultLoginBtn, "default login button");
    }

    @Step("Perform a successful login")
    public void login() {
        scrollIntoView(defaultLoginBtn);
        fillTextField(emailField, "email field", sensidev_userName);
        fillTextField(passwordField, "password field", sensidev_password);
        clickElement(defaultLoginBtn, "login button");
    }

    @Step("Perform login based on parameters")
    public void login(CredentialsModel credentialsModel) {
        scrollIntoView(defaultLoginBtn);
        fillTextField(emailField, "email field", credentialsModel.getEmail());
        fillTextField(passwordField, "password field", credentialsModel.getPassword());
        clickElement(defaultLoginBtn, "login button");
    }

    @Step("Verify error message is displayed")
    public void checkInvalidLoginErrorMessage(int index, String expected) throws InterruptedException {
        Thread.sleep(5000);
        waitUntilVisible(loginErrorMessagesList.get(index));
        Assert.assertEquals(loginErrorMessagesList.get(index).getText(), expected, "Error message not displayed");
    }
}
