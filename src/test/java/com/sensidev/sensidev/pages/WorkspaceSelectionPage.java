package com.sensidev.sensidev.pages;

import com.sensidev.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class WorkspaceSelectionPage extends BasePage {

    @FindBy(xpath = "//*[text()[contains(.,'Select workspace')]]")
    private WebElement selectWorkspaceText;
    @FindBy(xpath = "//*[text()[contains(.,\"Select a workspace\")]]")
    private WebElement selectAWorkspaceDropdown;

    @FindBy(css = "div[class^='DropdownItemstyle']")
    private List<WebElement> dropDownList;

    @FindBy(css = "div[class^='DropdownItemstyle'] > span")
    private List<WebElement> dropDownListValue;

    @FindBy(xpath = "(//button[@color='#ffffff'])[2]")
    private WebElement enterBtn;

    public WorkspaceSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify Login Page is displayed")
    public void verifyWorkSpaceSelectionPageIsDisplayed() {
        jsWaitForPageToLoad(10, driver);
        Assert.assertTrue(driver.getCurrentUrl().contains(BasePage.sensidev_baseURL), "Home Page is not displayed");
        waitUntilVisible(selectWorkspaceText);
    }

    @Step("Choose demo1 dashboard")
    public void chooseDemoDashboardValue(String dashboard, int index) {
        clickElement(selectAWorkspaceDropdown, "select a workspace dropdown");
        if (dropDownListValue.get(0).getText().equals(dashboard)) {
            clickElement(dropDownList.get(index), "element at index " + index + " is not " + dashboard);
        }
        clickEnterBtn();
    }

    @Step("Click enter button")
    public void clickEnterBtn() {
        clickElement(enterBtn, "enter button");
    }
}
