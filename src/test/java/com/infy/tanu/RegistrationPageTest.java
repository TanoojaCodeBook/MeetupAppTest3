package com.infy.tanu;

import Pages.RegistrationPage;
import Pages.WelcomePage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationPageTest {

    WebDriverWait wait;
    WebDriver driver;
    RegistrationPage rp;
    WelcomePage wp;
    String[] optionText={"Arts and Culture", "Career and Business", "Education and Learning", "Fashion and Learning","Games",};
    int i=0;
    @BeforeMethod
    public  void setUp(){
        driver=new FirefoxDriver();
        rp=new RegistrationPage(driver);
        wp=new WelcomePage(driver);
        driver.get("https://qameetup.ccbp.tech/");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wp.clickOnRegisterBtn();
    }
    @AfterMethod
    public  void tearDown(){
        driver.close();
    }



    @DataProvider
    public  Object[][] dataSet(){
        return  new Object[][]{
                {"Jack","ARTS_AND_CULTURE"}, {"Jerry","CAREER_AND_BUSINESS"}, {"John","EDUCATION_AND_LEARNING"}, {"Jim","FASHION_AND_BEAUTY"}, {"Jane","GAMES"}

        };
    }
    @Test
    public  void testRegistrationPageUI(){

        Assert.assertTrue(rp.getAppLogoImg().isDisplayed(),"App logo is not displayed");
        Assert.assertTrue(rp.getRegisterImg().isDisplayed(),"Register image is not displayed");

        Assert.assertEquals(rp.getHeadingText(),"Let us join","Heading text does not match");

    }

    @Test(priority = 1)
    public  void testRegistrationWithEmptyName(){
        rp.register("","ARTS_AND_CULTURE");
        Assert.assertEquals(rp.getErrorMsg(),"Please enter your name","Error text with empty input field does not match");

    }


    @Test(priority = 2,dataProvider = "dataSet")
    public  void testRegistrationWithValiInputs(String name, String topic){

       rp.register(name,topic);

       String expectedResult="Hello "+name;
       String actualResult=driver.findElement(By.xpath("//h1[contains(@class,'NameHeading')]")).getText();
       Assert.assertEquals(actualResult,expectedResult,"Heading text does not match");
       String expectedTopic="Welcome to "+optionText[i];
       String actualTopic=driver.findElement(By.xpath("//p[contains(@class,'TopicDescription')]")).getText();
       Assert.assertEquals(actualTopic,expectedTopic,"Description text does not match");
       i++;

    }

}
