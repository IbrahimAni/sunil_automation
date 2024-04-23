package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Homepage extends BasePage{
    WebDriver driver;
    Logger logger = Logger.getLogger(Homepage.class);

    public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//*[@id='logo']")
    WebElement imageLogo;

    @FindBy(xpath = "//h1[@class='et_pb_module_header']")
    WebElement pageTitle;

    @FindBy(xpath = "//a[contains(@class, 'et_pb_button_one')]")
    WebElement linkReadBlog;

    @FindBy(xpath = "//a[contains(@class, 'et_pb_button_two')]")
    WebElement linkContactMe;

    @FindBy(xpath = "//div[contains(@class, 'et_pb_row_0')]")
    List<WebElement> partners;

    @FindBy(xpath = "/html/body/div/header/div[1]/div[2]/nav/ul/li[1]/a")
    WebElement linkBlog;

    @FindBy(xpath = "/html/body/div/header/div[1]/div[2]/nav/ul/li[2]/a")
    WebElement linkContact;

    @FindBy(xpath = "//h1[normalize-space()='Read All Abo']")
    WebElement sectionHeader1;
    
    @FindBy(xpath = "//article[contains(@class,'et_pb_post')]")
    List<WebElement> blogPosts;

    @FindBy(xpath = "//h2[contains(@class,'entry-title')]//a")
    WebElement blogPostLink;

    @FindBy(xpath = "//div[contains(@class,'et_pb_image_container')]//a//img")
    WebElement blogPostImg;

    @FindBy(xpath = "//h2[@class='entry-title']")
    WebElement blogPostTitle;

    @FindBy(xpath = "//p[contains(@class,'post-meta')]")
    WebElement blogPostCategory;

    @FindBy(xpath = "//div[contains(@class,'post-content-inner')]")
    WebElement blogPostContent;

    @FindBy(xpath = "//h1[normalize-space()='Read All About It']")
    WebElement sectionHeader2;

    @FindBy(xpath = "//a[@aria-current='page']")
    List<WebElement> topMenus;

    @FindBy(xpath = "//div[@class='et_pb_salvattore_content']")
    List<WebElement> blogPostColumns;

    //Methods
    public boolean isLogoDisplayed() {
        logger.info("Checking if logo is displayed : " +isDisplayed(imageLogo));
        return isDisplayed(imageLogo);
    }

    public void isPageTitleDisplayed() {
        isDisplayed(pageTitle);
        logger.info("Page title is displayed");
    }

    public String getPageTitle() {
        logger.info("Getting page title :" + getText(pageTitle));
        return getText(pageTitle);
    }

    public void clickReadBlogBtn() {
        click(linkReadBlog);
        logger.info("Clicked on Read Blog link");
    }

    public void clickContactMe() {
        click(linkContactMe);
        logger.info("Clicked on Contact Me link");
    }

//    public void clickBlog() {
//        click(linkBlog);
//        logger.info("Clicked on Blog link");
//    }
//
//    public void clickContact() {
//        click(linkContact);
//        logger.info("Clicked on Contact link");
//    }

    public void isCategoryHeader1Displayed() {
        isDisplayed(sectionHeader1);
        logger.info("Category header 1 is displayed");
    }

    public void isCategoryHeader2Displayed() {
        isDisplayed(sectionHeader2);
        logger.info("Category header 2 is displayed");
    }

    public void isPartnersDisplayed(int numberOfPartners) {
        if (partners.size() == numberOfPartners) {
            logger.info("All " +numberOfPartners+ " partners are displayed");
        } else {
            logger.error("Not all partners are not displayed");
        }
    }

    public void isBlogPostsDisplayed() {
        if (!blogPosts.isEmpty()) {
            logger.info("Blog posts are displayed");
        } else {
            logger.error("Blog posts are not displayed");
        }
    }

    public void clickBlogPost() {
        for (WebElement post : blogPosts) {
            //confirm that all blog post are clickable
            click(post);
        }
    }

    public void clickMenuLink(String menuName) {
        for (WebElement menu : topMenus) {
            System.out.println(menu.getText());
            if (menu.getText().equalsIgnoreCase(menuName)) {
                click(menu);
                logger.info("Clicked on menu link : " + menuName);
                break;
            }
        }
    }

    public void isTopMenusDisplayed() {
        if (!topMenus.isEmpty()) {
            logger.info("Top menus are displayed");
        } else {
            logger.error("Top menus are not displayed");
        }
    }

    public int getNumberOfBlogPosts() {
        return blogPosts.size();
    }

    public boolean isBlogPostImgDisplayed() {
        logger.info("Checking if blog post image is displayed : " +isDisplayed(blogPostImg));
        return isDisplayed(blogPostImg);
    }

    public boolean isBlogPostTitleDisplayed() {
        logger.info("Checking if blog title is displayed : " +isDisplayed(blogPostTitle));
        return isDisplayed(blogPostTitle);
    }

    public boolean isBlogPostCategoryDisplayed() {
        logger.info("Checking if blog category is displayed : " +isDisplayed(blogPostCategory));
        return isDisplayed(blogPostCategory);
    }

    public boolean isBlogPostContentDisplayed() {
        logger.info("Checking if blog content is displayed : " +isDisplayed(blogPostContent));
        return isDisplayed(blogPostContent);
    }

    public void clickBlogPostCategoryLink() {
        click(blogPostCategory);
        logger.info("Clicked on blog post category");
    }

    public void navigateBack(WebDriver driver){
        goBack(driver);
        logger.info("Navigated back to previous page");
    }

    public void clicktoOpenBlogPost() {
        click(blogPostLink);
//        logger.info("Clicked on blog post link : " + blogPostTitle.getText());
    }

    public String getBlogPostTitle() {
//        logger.info("Getting blog post title : " + blogPostTitle.getText());
        return getText(blogPostTitle);
    }

    public String getPageTitle(WebDriver driver) {
        return getPageTitle(driver);
    }

    public int getNumbersOfArticlesInThisColumn() {
        return blogPostColumns.size();
    }


}
