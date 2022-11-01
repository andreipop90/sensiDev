package com.sensidev.techlistic.page;

import com.sensidev.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    @FindBy(css = "button[id='ez-accept-all']")
    private WebElement acceptCookiesButton;

    @FindBy(css = "#cookieChoiceDismiss")
    private WebElement cookieChoiceDismiss;

    @FindBy(css = "#sex-1")
    private WebElement femaleRadioButton;

    @FindBy(css = "input[name='firstname']")
    private WebElement firstNameField;

    @FindBy(css = "input[name='lastname']")
    private WebElement lastNameField;

    @FindBy(css = "#exp-0")
    public static WebElement oneYearOfExperienceRadioButton;

    @FindBy(css = "#exp-1")
    public static WebElement twoYearsOfExperienceRadioButton;

    @FindBy(css = "#exp-2")
    public static WebElement threeYearsOfExperienceRadioButton;

    @FindBy(css = "#profession-1")
    private WebElement automationTesterCheckbox;

    @FindBy(css = "#tool-2")
    private WebElement seleniumWebDriverCheckbox;

    @FindBy(css = "#submit")
    private WebElement submitButton;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Accept all cookies")
    public void acceptAllCookies() {
        waitUntilVisible(acceptCookiesButton);
        clickElement(acceptCookiesButton, "accept cookies button");
        clickElement(cookieChoiceDismiss, "cookie choice dismiss");
    }

    @Step("Verify home page is displayed")
    public void verifyHomePageIsDisplayed() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.techlistic.com/p/selenium-practice-form.html", "URL is not correct");
    }

    @Step("Fill first name field")
    public void fillFirstNameField(String firstName) {
        fillTextField(firstNameField, "first name field", firstName);
    }

    @Step("Fill last name field")
    public void fillLastNameField(String lastName) {
        fillTextField(lastNameField, "last name field", lastName);
    }

    @Step("Choose female radio button")
    public void selectFemaleRadioButton() {
        clickElement(femaleRadioButton, "female radio button");
    }

    @Step("Select automation checkbox")
    public void selectAutomationCheckbox() {
        clickElement(automationTesterCheckbox, "automation tester checkbox");
    }

    @Step("Select selenium webdriver checkbox")
    public void selectSeleniumWebDriverCheckbox() {
        clickElement(seleniumWebDriverCheckbox, "selenium webdriver checkbox");
    }

    @Step("Submit form")
    public void submitForm() {
        clickElement(submitButton, "submit button");
    }

    public void clickByCss(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
    }
}
