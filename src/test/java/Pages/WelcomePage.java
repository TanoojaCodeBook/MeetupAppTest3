package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

WebDriver driver;

 public   WelcomePage(WebDriver driver){
    this.driver=driver;
     PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//img[@alt='website logo']")
    WebElement appLogImgEle;

   @FindBy(xpath = "//h1[text()='Welcome to Meetup']")
    WebElement headingEle;

   @FindBy(xpath = "//p[contains(@class,'Description')]")
    WebElement descriptionEle;

   @FindBy(id = "registerButton")
   @CacheLookup
    WebElement registerBtnEle;


   public  WebElement getAppLogoImg(){
       return  appLogImgEle;
   }

   public String getHeadingText(){
     return   headingEle.getText();
   }

   public  String getDescriptionText(){
     return   descriptionEle.getText();
   }
   public  void clickOnRegisterBtn(){
       registerBtnEle.click();
   }
}
