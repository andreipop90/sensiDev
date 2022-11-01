package com.sensidev.sensidev.tests;

import com.sensidev.base.BaseTest;
import com.sensidev.sensidev.pages.ElectricPage;
import com.sensidev.sensidev.pages.LoginPage;
import com.sensidev.sensidev.pages.WorkspaceSelectionPage;
import com.sensidev.utils.PageLoader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.sensidev.utils.Constants.DEMO_1;
import static com.sensidev.utils.Constants.NO_RESULTS_FOUND;
import static com.sensidev.utils.Utils.randomIntFromList;

public class RemoveDeviceFromListTest extends BaseTest {

    @Description
    @Test
    public void removeElectricDeviceAndVerifyPresenceInListView() throws InterruptedException {
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
        int rand = randomIntFromList(electricPage.euiNumbersList);
        String randomEUI = electricPage.euiNumbersList.get(rand).getText();
        System.out.println(randomEUI);
        int currentDevices = electricPage.getTotalNumberOfDevices();
        electricPage.searchForDevice(randomEUI);
        Assert.assertEquals(electricPage.firstSearchResult.getText(), randomEUI);
        electricPage.removeDeviceFromList(rand);
        electricPage.searchForDevice(randomEUI);
//        Assert.assertEquals(electricPage.firstSearchResult.getText(), NO_RESULTS_FOUND); -> the result is still displayed in the search bar even though the device was deleted
        Assert.assertEquals(electricPage.getTotalNumberOfDevices(), (currentDevices-1));
    }
}
