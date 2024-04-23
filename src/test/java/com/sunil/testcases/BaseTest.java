package com.sunil.testcases;

import constants.Browser;
import constants.StringConstant;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BlogPage;
import pages.Homepage;
import utils.BrowserFactory;

public class BaseTest {
    WebDriver driver;
    StringConstant stringConstant = new StringConstant();

    public BaseTest() {
        PropertyConfigurator.configure(stringConstant.log4jFilePath());
    }

    @BeforeSuite
    public void setUp() {
        driver = BrowserFactory.startApplication(driver, Browser.CHROME, stringConstant.APPLICATION_URL());
    }

    @AfterSuite
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }

    //Pages Initialization
    Homepage homepage;
    BlogPage blogPage;
}
