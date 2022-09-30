package com.sensidev.wiki.page;

import com.sensidev.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiHomePage extends BasePage {

    @FindBy(css = ".vector-search-box-input")
    private WebElement searchField;

    @FindBy(css = "#searchButton")
    private WebElement searchButton;

    public WikiHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Search for input")
    public void searchForInput(String input) {
        fillTextField(searchField, "search field", input);
        clickElement(searchButton, "search button");
    }
}
