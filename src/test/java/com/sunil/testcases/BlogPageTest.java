package com.sunil.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.Homepage;

public class BlogPageTest extends BaseTest{
    Logger logger = Logger.getLogger(BlogPageTest.class);

    @BeforeClass
    public void initialize() {
        homepage = new Homepage(driver);
        blogPage = new BlogPage(driver);
        logger.info("BlogPage Test Started");
        logger.info("Site is opened");
    }

    @Test(description = "Test to verify that user can read blog post")
    public void testUserCanReadBlogPost() {
        try{
            homepage.clicktoOpenBlogPost();
            String titleHeader = blogPage.getTitleHeader();
            String content = blogPage.getBlogContent();
            if(!titleHeader.isEmpty() && !content.isEmpty()){
                Assert.assertTrue(true);
            }else {
                Assert.fail("Failed to read blog post, title or content is empty");
            }
        }catch (Exception e){
            Assert.fail("Failed to read blog post, title or content is empty");
        }
    }

    @Test(description = "Test to verify that user can subscrib to a blog post")
    public void testUserCanSubscribeToBlogPost() {
        try{
            homepage.clicktoOpenBlogPost();

            blogPage.enterEmail("sample@test.com");
            blogPage.clickSubscribeBtn();
            if (blogPage.getEmailTxtValue().isEmpty()) {
                Assert.assertTrue(blogPage.getEmailTxtValue().isEmpty());
            } else {
                Assert.fail("Failed to subscribe to blog post, email is not submitted");
            }
        }catch (Exception e){
            Assert.fail("Failed to subscribe to blog post, email is not submitted");
        }

    }
}
