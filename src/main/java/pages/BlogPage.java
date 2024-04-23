package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage extends BasePage{
    WebDriver driver;
    Logger logger = Logger.getLogger(BlogPage.class);

    public BlogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locate elements
    @FindBy(xpath = "//div[@class='et_pb_text_inner']//h1")
    WebElement blogTitleHeader;

    @FindBy(xpath = "//div[@class='et_pb_text_inner']//p")
    WebElement blogContent;

    @FindBy(xpath = "//input[@id='et_pb_signup_email']")
    WebElement emailTxt;

    @FindBy(xpath = "//a[@class='et_pb_newsletter_button et_pb_button']")
    WebElement subscribeBtn;

    //Methods
    public String getTitleHeader() {
        logger.info("Getting the title header.");
        return getText(blogTitleHeader);
    }

    public String getBlogContent() {
        logger.info("Getting the blog content.");
        return getText(blogContent);
    }

    public void enterEmail(String email) {
        logger.info("Entering email.");
        enterText(emailTxt, email);
    }

    public void clickSubscribeBtn() {
        logger.info("Clicking subscribe button.");
        click(subscribeBtn);
    }

    public String getEmailTxtValue() {
        logger.info("Getting email text value.");
        return emailTxt.getAttribute("value");
    }

    public WebElement emailInputTextField() {
        return driver.findElement(By.xpath("//input[@id='et_pb_signup_email']"));
    }

}
