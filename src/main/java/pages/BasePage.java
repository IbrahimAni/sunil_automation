package pages;

import constants.StringConstant;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriverWait wait;
    StringConstant stringConstant = new StringConstant();

    public BasePage() {
        PropertyConfigurator.configure(stringConstant.log4jFilePath());
    }

    /**
     * This method is used to click a button
     * @param element
     */
    protected void click(WebElement element) {
        element.click();
    }

    /**
     * This method is used to enter text in a text field
     * @param element
     * @param text
     */
    protected void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * This method is used to get the text of an element
     * @param element
     * @return
     */
    protected String getText(WebElement element) {
        return element.getText();
    }

    /**
     * This method is used to check if an element is displayed
     * @param element
     * @return
     */
    protected boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * This method is used to check if an element is enabled
     * @param element
     * @return
     */
    protected boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    /**
     * This method is used to check if an element is selected
     * @param element
     * @return
     */
    protected boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    /**
     * This method is used to clear the text of an element
     * @param element
     */
    protected void clear(WebElement element) {
        element.clear();
    }

    /**
     * This method is used to get the attribute of an element
     * @param element
     * @param attribute
     * @return
     */
    protected String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    /**
     * This method is used to submit a form
     * @param element
     */
    protected static void submit(WebElement element){
        element.submit();
    }

    /**
     * This method is used to click an element using JavaScript
     * @param element
     */
    protected void clickUsingJS(WebElement element, WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * This method is used to scroll to an element using JavaScript
     * @param element
     */
    protected void scrollToElementJs(WebElement element, WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * This method is used to move to an element with Action
     */
    protected void scrollToElement(WebElement element, WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * This method is used to drag and drop an element
     */
    protected void dragAndDrop(WebElement source, WebElement target, WebDriver driver){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }

    /**
     * This method is used to click and hold an element
     */
    protected void clickAndHold(WebElement element, WebDriver driver){
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();
    }

    /**
     * This method is used to release an element
     */
    protected void release(WebElement element, WebDriver driver){
        Actions actions = new Actions(driver);
        actions.release(element).build().perform();
    }

    /**
     * This method is used to right-click
     */
    protected void rightClick(WebElement element, WebDriver driver){
        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();
    }

    /**
     * This method is used to double click
     */
    protected void doubleClick(WebElement element, WebDriver driver){
        Actions actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
    }

    /**
     * This method is used to switch to a frame
     */
    protected void switchToFrame(WebElement element, WebDriver driver){
        driver.switchTo().frame(element);
    }

    /**
     * This method is used to switch back fro frame
     */
    protected void switchBackFromFrame(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    /**
     * This method is used to refresh the page
     */
    protected void refresh(WebDriver driver){
        driver.navigate().refresh();
    }

    /**
     * This method is used to go back to the previous page
     */
    protected void goBack(WebDriver driver){
        driver.navigate().back();
    }

    /**
     * This method is used to go forward to the next page
     */
    protected void goForward(WebDriver driver){
        driver.navigate().forward();
    }

    /**
     * This method is used to wait for an element to be clickable
     */
    protected void waitForElementToBeClickable(WebElement element, WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((driver1) -> element);
    }

    /**
     * This method is used right-click in java
     */
    protected void rightClickJs(WebElement element, WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("arguments[0].contextmenu();", element);
    }

    /**
     * This method is used to double click an element
     */
    protected void doubleClickJs(WebElement element, WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("arguments[0].dblclick();", element);
    }

    /**
     * This method is used to get the URL of a page
     */
    protected String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    /**
     * This method is used to get the title of a page
     */
    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

}
