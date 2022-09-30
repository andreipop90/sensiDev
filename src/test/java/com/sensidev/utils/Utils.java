package com.sensidev.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Utils {

    public static final int randomIntFromList(List<WebElement> list) {
        Random random = new Random();
        return random.nextInt(list.size());
    }

    public static void waitForElementAttributeEqualsString(WebElement element, String attribute, String expectedString,
                                                    WebDriver driver, int specifiedTimeout) {
        WebDriverWait wait = new WebDriverWait(driver, specifiedTimeout);
        ExpectedCondition<Boolean> elementAttributeEqualsString = arg0 -> element.getAttribute(attribute).equals
                (expectedString);
        wait.until(elementAttributeEqualsString);
    }
}
