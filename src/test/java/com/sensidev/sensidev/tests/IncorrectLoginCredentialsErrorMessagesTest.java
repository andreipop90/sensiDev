package com.sensidev.sensidev.tests;

import com.sensidev.base.BaseTest;
import com.sensidev.data.CredentialsModel;
import com.sensidev.sensidev.pages.LoginPage;
import com.sensidev.utils.PageLoader;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.sensidev.utils.Constants.NO_ACTIVE_CODE_FOUND_ERROR_MESSAGE;
import static com.sensidev.utils.Constants.PLEASE_CHECK_AGAIN_ERROR_MESSAGE;

public class IncorrectLoginCredentialsErrorMessagesTest extends BaseTest {

    @Description
    @Test
    public void loginWithIncorrectCredentials() throws InterruptedException {
        PageLoader.loadSensidevHomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageIsDisplayed();
        loginPage.clickDefaultLoginBtn();
        CredentialsModel user = new CredentialsModel();
        loginPage.login(user);
        loginPage.checkInvalidLoginErrorMessage(0, NO_ACTIVE_CODE_FOUND_ERROR_MESSAGE);
        loginPage.checkInvalidLoginErrorMessage(1, PLEASE_CHECK_AGAIN_ERROR_MESSAGE);
    }
}
