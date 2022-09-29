package com.sensidev.techlistic.tests;

import com.sensidev.base.BaseTest;
import com.sensidev.techlistic.page.HomePage;
import com.sensidev.utils.PageLoader;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CompleteFormBasedOnRequirementsTest extends BaseTest {

    @DataProvider(name = "testerData")
    public Object[] testerData() {
        return new Object[][]{
                {"Ana", "Stone", "#exp-0"},
                {"Jane", "Turner", "#exp-1"},
                {"Lisa", "Warden", "#exp-2"},
        };
    }

    @Description
    @Test(dataProvider = "testerData")
    public void completeForm(String firstName, String lastName, String yearsOfExperienceRadioButton) throws InterruptedException {
        PageLoader.loadTechlisticPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.acceptAllCookies();
        homePage.verifyHomePageIsDisplayed();
        homePage.fillFirstNameField(firstName);
        homePage.fillLastNameField(lastName);
        homePage.selectFemaleRadioButton();
        homePage.clickByCss(yearsOfExperienceRadioButton);
        homePage.selectAutomationCheckbox();
        homePage.selectSeleniumWebDriverCheckbox();
        homePage.submitForm();
    }
}
