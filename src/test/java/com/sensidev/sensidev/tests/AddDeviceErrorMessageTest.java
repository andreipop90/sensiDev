package com.sensidev.sensidev.tests;

import com.sensidev.base.BaseTest;
import com.sensidev.sensidev.pages.ElectricPage;
import com.sensidev.sensidev.pages.LoginPage;
import com.sensidev.sensidev.pages.WorkspaceSelectionPage;
import com.sensidev.utils.PageLoader;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.sensidev.utils.Constants.DEMO_1;
import static com.sensidev.utils.Constants.EUI_EMPTY_ERROR_MESSAGE;

public class AddDeviceErrorMessageTest extends BaseTest {

    @Description
    @Test
    public void receiveErrorMessageForIncorrectLength() throws InterruptedException {
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
        electricPage.clickAddDeviceButton();
        electricPage.verifyRegisterDeviceModalIsDisplayed();
        electricPage.fillEuiFieldAndRegisterDevice("");
        electricPage.verifyErrorMessageIsDisplayed(EUI_EMPTY_ERROR_MESSAGE);
    }
}
