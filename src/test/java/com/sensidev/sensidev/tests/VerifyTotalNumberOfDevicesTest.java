package com.sensidev.sensidev.tests;

import com.sensidev.base.BaseTest;
import com.sensidev.sensidev.pages.ElectricPage;
import com.sensidev.sensidev.pages.LoginPage;
import com.sensidev.sensidev.pages.WorkspaceSelectionPage;
import com.sensidev.utils.PageLoader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.sensidev.utils.Constants.*;

public class VerifyTotalNumberOfDevicesTest extends BaseTest {

    @Description("")
    @Test
    public void checkTotalNumberOfDevices() throws InterruptedException {
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
        int offlineDevices = electricPage.getNumberOfDevicesInListBasedOnStatus(STATUS_OFFLINE);
        int onLineDevices = electricPage.getNumberOfDevicesInListBasedOnStatus(STATUS_ONLINE);
        Assert.assertEquals(electricPage.getTotalNumberOfDevices(), (offlineDevices + onLineDevices));
    }
}
