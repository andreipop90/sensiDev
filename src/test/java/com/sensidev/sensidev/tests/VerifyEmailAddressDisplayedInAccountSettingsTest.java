package com.sensidev.sensidev.tests;

import com.sensidev.base.BaseTest;
import com.sensidev.sensidev.pages.AccountSettingsPage;
import com.sensidev.sensidev.pages.ElectricPage;
import com.sensidev.sensidev.pages.LoginPage;
import com.sensidev.sensidev.pages.WorkspaceSelectionPage;
import com.sensidev.utils.PageLoader;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.sensidev.utils.Constants.DEMO_1;

public class VerifyEmailAddressDisplayedInAccountSettingsTest extends BaseTest {

    @Description
    @Test
    public void verifyInactiveEmailAddressPresentInAccountSettingsPage() throws InterruptedException {
        PageLoader.loadSensidevHomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageIsDisplayed();
        loginPage.clickDefaultLoginBtn();
        loginPage.login();

        WorkspaceSelectionPage workspaceSelectionPage = new WorkspaceSelectionPage(driver);
        workspaceSelectionPage.verifyWorkSpaceSelectionPageIsDisplayed();
        workspaceSelectionPage.chooseDemoDashboardValue(DEMO_1, 0);

        ElectricPage electricPage = new ElectricPage(driver);
        electricPage.verifyElectricPageIsDisplayed();
        electricPage.goToAccountSettings();

        AccountSettingsPage accountSettingsPage = new AccountSettingsPage(driver);
        accountSettingsPage.verifyAccountSettingsPageIsDisplayed();
        accountSettingsPage.verifyEmailFieldIsInactiveAndDisplayed();
    }
}
