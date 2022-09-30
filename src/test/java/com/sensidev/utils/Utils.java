package com.sensidev.utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Utils {

    public static final int randomIntFromList(List<WebElement> list) {
        Random random = new Random();
        return random.nextInt(list.size());
    }
}
