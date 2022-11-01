package com.sensidev.sensidev.pages;

import com.sensidev.base.BasePage;
import com.sensidev.utils.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sensidev.utils.Constants.START_DEVICE_REGISTRATION;

public class ElectricPage extends BasePage {

    @FindBy(css = "div[class^=style__DevicesWrapper] > div[class^=Layoutstyle__Row]")
    private List<WebElement> electricDevicesList;

    @FindBy(css = "div[class^=style__DevicesWrapper] > div[class^=Layoutstyle__Row] >div[class^=Layoutstyle__Column]:nth-of-type(2) > div[class^=Layoutstyle__Row]  > p")
    private List<WebElement> electricDevicesStatusList;

    @FindBy(css = "div[class^=style__DevicesWrapper] > div[class^=Layoutstyle__Row]  >  div[class^=Layoutstyle__Row] > div > div >svg")
    private List<WebElement> electricDevicesOptionsList;

    @FindBy(css = "div[role='listbox'] > div > div > div> div:nth-of-type(3)")
    private WebElement removeDeviceButton;

    @FindBy(css = "div[class^='style__DevicesWrapper'] > div[class^='Layoutstyle__Row'] > div[class^=Layoutstyle] > h6")
    public List<WebElement> euiNumbersList;

    @FindBy(css = "#devices")
    private WebElement searchField;

    @FindBy(xpath = "//span[text()='Remove device']")
    private WebElement confirmRemoveButton;

    @FindBy(css = "div[role=\"listbox\"] > div > div > div > div >span")
    public WebElement firstSearchResult;

    @FindBy(css = "#confirm")
    public WebElement deleteField;

    @FindBy(xpath = "//span[text()='Remove device']")
    private WebElement removeDeviceFromModalButton;
    @FindBy(css = "header[class^='PageHeaderstyle__'] > div[class^='Layout'] > button:nth-of-type(1)")
    private WebElement addDeviceButton;

    @FindBy(css = "h6[class^='AddDeviceModalstyle__Subtitle-sc']")
    private WebElement startDeviceRegistrationText;

    @FindBy(css = "#eui")
    private WebElement euiField;

    @FindBy(xpath = "//span[text()='Check Device']")
    private WebElement checkDeviceButton;

    @FindBy(xpath = "//span[text()='Register Device']")
    private WebElement registerDeviceButton;

    @FindBy(css = "p[class^='style__Error']")
    private WebElement errorMessage;

    @FindBy(css = "div[class^='Sidebarstyle__Bottom'] > div > div ")
    private WebElement accountSettingsBtn;

    public ElectricPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify Electric Page is displayed")
    public void verifyElectricPageIsDisplayed() {
        waitForURL("https://app.sensix.xyz/demo1/dashboard/electric?page=1&range=0", driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Step("Return number of online devices in list")
    public int getNumberOfDevicesInListBasedOnStatus(String status) {
        int numberOfDevices = 0;
        for (WebElement s : electricDevicesStatusList) {
            if (s.getText().equals(status)) {
                numberOfDevices++;
            }
        }
        return numberOfDevices;
    }

    @Step("Return total number of devices")
    public int getTotalNumberOfDevices() {
        return electricDevicesList.size();
    }

    public List<WebElement> getOfflineDevicesList() {
        List<WebElement> offlineDevices = new ArrayList<>();
        try {
            for (WebElement element : electricDevicesStatusList) {
                if (element.getText().equals(Constants.STATUS_OFFLINE)) {
                    offlineDevices.add(element);
                }
            }
        } catch (Exception e) {
            System.out.println("No offline devices");
        }
        return offlineDevices;
    }

    @Step("Remove device from list")
    public void removeDeviceFromList(int index) {
        clickElement(electricDevicesOptionsList.get(index), "electric device option");
        clickElement(removeDeviceButton, "remove device button");
        clickElement(confirmRemoveButton, "confirm remove device button from modal");
        fillTextField(deleteField, "delete confirmation field", "delete");
        clickElement(removeDeviceFromModalButton, "remove device button");
    }

    @Step("Search for device")
    public void searchForDevice(String eui) throws InterruptedException {
        clickElement(searchField, "search field");
        fillTextField(searchField, "search field", eui);
        Thread.sleep(5000);
    }

    @Step("Click add device button")
    public void clickAddDeviceButton() {
        clickElement(addDeviceButton, "add device button");
    }

    @Step("Verify device add modal is displayed")
    public void verifyRegisterDeviceModalIsDisplayed() {
        waitUntilVisible(startDeviceRegistrationText);
        Assert.assertEquals(startDeviceRegistrationText.getText(), START_DEVICE_REGISTRATION, "Register device modal is not displayed");
    }

    @Step("Fill eui")
    public void fillEuiFieldAndRegisterDevice(String eui) {
        fillTextField(euiField, "eui field", eui);
        clickElement(registerDeviceButton, "Register device button");
    }

    @Step("Verify error message is displayed")
    public void verifyErrorMessageIsDisplayed(String expected) {
        Assert.assertEquals(errorMessage.getText(), expected);
    }

    @Step("Go to account settings page")
    public void goToAccountSettings() {
        clickElement(accountSettingsBtn, "account settings button");
    }
}
