package utils;

import constants.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserFactory {
    static WebDriverWait wait;
    static final ChromeOptions chromeOptions = new ChromeOptions();
    static final FirefoxOptions firefoxOptions = new FirefoxOptions();
    static final InternetExplorerOptions ieOptions = new InternetExplorerOptions();

    public static WebDriver startApplication(WebDriver driver, Browser browserName, String appURL) {
        if(browserName.equals(Browser.CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if(browserName.equals(Browser.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        } else if(browserName.equals(Browser.IE)) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver(ieOptions);
        } else {
            System.out.println("We do not support this browser yet!");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();
    }
}
