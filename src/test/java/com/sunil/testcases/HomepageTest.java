package com.sunil.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.Homepage;

public class HomepageTest extends BaseTest{
    Logger logger = Logger.getLogger(HomepageTest.class);

    @BeforeClass
    public void initialize() {
        homepage = new Homepage(driver);
        blogPage = new BlogPage(driver);
        logger.info("Homepage Test Started");
        logger.info("Site is opened");

    }

    @Test(description = "Test to verify that site logo is displayed", groups = {"smoke", "regression"})
    public void testSiteLogoIsDisplayed() {
        try{
            if(homepage.isLogoDisplayed()){
                Assert.assertTrue(homepage.isLogoDisplayed());
            }else{
                Assert.fail("Logo is not displayed");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    @Test(description = "Test to verify that blog section properties are displayed and not empty", groups = {"smoke", "regression"})
//    public void testBlogSectionProperties() {
//        for(int i = 0; i < homepage.getNumberOfBlogPosts(); i++) {
//            Assert.assertTrue(homepage.isBlogPostImgDisplayed());
//            Assert.assertTrue(homepage.isBlogPostTitleDisplayed());
//            Assert.assertTrue(homepage.isBlogPostCategoryDisplayed());
//            Assert.assertTrue(homepage.isBlogPostContentDisplayed());
//        }
//    }

    @Test(description = "Test to verify that blog section category link are clickable", groups = {"smoke", "regression"})
    public void testBlogSectionCategoryLink() {
        try{
            for(int i = 0; i < homepage.getNumberOfBlogPosts(); i++) {
                homepage.clickBlogPostCategoryLink();
                if(driver.getCurrentUrl().contains("category")){
                    Assert.assertTrue(true);
                }else{
                    Assert.fail("Failed to navigate to blog category page");
                }
            }
        }catch(Exception e){
            Assert.fail("Failed to navigate to blog category page");
        }
    }

    @Test(description = "Test to verify that user can navigate to blog page")
    public void testUserCanOpenABlog() {
        for(int i = 0; i < homepage.getNumberOfBlogPosts(); i++) {
            System.out.println("getNumbersOfArticlesInThisColumn :" +homepage.getNumbersOfArticlesInThisColumn());
            String blogTitle = homepage.getBlogPostTitle();
            homepage.clicktoOpenBlogPost();
            String pageTitle = homepage.getPageTitle(driver);
            System.out.println(blogTitle + " This : This " +pageTitle);
            if(pageTitle.contains(blogTitle)){
                Assert.assertTrue(true);
            }else{
                Assert.fail("Failed to navigate to blog page");
            }
            homepage.navigateBack(driver);
        }
    }

    @Test(description = "Test to verify that user can navigate to menu links")
    public void testUserCanNavigateToMenuLinks() {
        homepage.clickMenuLink("Blog");
        if(driver.getCurrentUrl().contains("blog")){
            Assert.assertTrue(true);
        }else{
            Assert.fail("Failed to navigate to Blog section");
        }

        homepage.clickMenuLink("Contact");
        if(driver.getCurrentUrl().contains("contact")){
            Assert.assertTrue(true);
        }else{
            Assert.fail("Failed to navigate to Contact section");
        }
    }

    @Test(description = "Test to verify that user can navigate Blog Page")
    public void testUserCanNavigateToBlogPage() {
        homepage.clickReadBlogBtn();
        if(driver.getCurrentUrl().contains("blogs")){
            Assert.assertTrue(true);
        }else{
            Assert.fail("Failed to navigate to Blog page, currently on: " +driver.getCurrentUrl());
        }
    }
}
