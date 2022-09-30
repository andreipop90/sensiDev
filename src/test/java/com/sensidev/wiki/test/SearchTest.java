package com.sensidev.wiki.test;

import com.sensidev.base.BaseTest;
import com.sensidev.utils.PageLoader;
import com.sensidev.wiki.page.WikiHomePage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @DataProvider(name = "wikiData")
    public Object[] wikiData() {
        return new Object[][]{
                {"go game", "https://en.wikipedia.org/", "Go (game) - Wikipedia"},
                {"Go (Spiel)", "https://de.wikipedia.org/", "Go (Spiel) – Wikipedia"}
        };
    }

    @Description
    @Test(dataProvider = "wikiData")
    public void searchTest(String searchInput, String url, String title) {
        PageLoader.loadURL(driver, url);
        WikiHomePage wikiHomePage = new WikiHomePage(driver);
        wikiHomePage.searchForInput(searchInput);
        Assert.assertEquals(driver.getTitle(), title);
    }
}
