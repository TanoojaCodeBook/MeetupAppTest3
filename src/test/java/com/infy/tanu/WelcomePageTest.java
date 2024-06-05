package com.infy.tanu;

import Pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WelcomePageTest {


    WebDriver driver;
    WelcomePage wp;
    WebDriverWait wait;
    @BeforeMethod
    public  void setUp(){
        driver=new FirefoxDriver();
        wp=new WelcomePage(driver);
        driver.get("https://qameetup.ccbp.tech/");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public  void tearDown(){
        driver.close();
    }

    @Test
    public  void testWelcomePageUI(){
        Assert.assertTrue(wp.getAppLogoImg().isDisplayed(),"App logo is not displayed");
      Assert.assertEquals(wp.getHeadingText(),"Welcome to Meetup","Heading text does not match");
      Assert.assertEquals(wp.getDescriptionText(),"Please register for the topic","Description text does not match");


    }

    @Test(priority = 1)
    public  void testFunctionalityOfWelcomePage(){
        wp.clickOnRegisterBtn();
        wait.until(ExpectedConditions.urlToBe("https://qameetup.ccbp.tech/register"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qameetup.ccbp.tech/register","URLs do not match");
    }
}
