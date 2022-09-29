package com.sensidev.base;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

@ContextConfiguration(locations = {"classpath:application-context-tests.xml"})
public class BaseTest extends AbstractTestNGSpringContextTests {

    public WebDriver driver;

    @Value("${sensidev_baseURL}")
    public String sensidev_baseURL;
    @Value("${sensidev_userName}")
    public  String sensidev_userName;
    @Value("${sensidev_password}")
    public  String sensidev_password;
    @Value("${techlistic_baseURL}")
    public  String techlistic_baseURL;
    @Value(("$wikiEN_baseURL"))
    public String wikiEN_baseURL;
    @Value(("$wikiDE_baseURL"))
    public String wikiDE_baseURL;

    @BeforeMethod(alwaysRun = true)
    protected void setUp() {
        //Set parameters in BasePage to be used in page classes
//        BasePage.env = env;
//        BasePage.browser = browser;
        BasePage.sensidev_baseURL = sensidev_baseURL;
        BasePage.sensidev_userName = sensidev_userName;
        BasePage.sensidev_password = sensidev_password;
        BasePage.techlistic_baseURL = techlistic_baseURL;
        BasePage.wikiEN_baseURL = wikiEN_baseURL;
        BasePage.wikiDE_baseURL = wikiDE_baseURL;

        //Instantiate driver and lunch browser
        driver = BrowserFactory.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown(Method method) {
        driver.quit();
    }
}
