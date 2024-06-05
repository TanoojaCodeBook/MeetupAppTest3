package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

WebDriver driver;
Select dropdownOptions;
  public  RegistrationPage(WebDriver driver){
    this.driver=driver;
      PageFactory.initElements(driver,this);
}
@FindBy(xpath = "//img[@alt='website logo']")
WebElement applogoEle;

@FindBy(xpath = "//h1[normalize-space()='Let us join']")
    WebElement headingEle;
@FindBy(xpath = "//img[@alt='website register']")
WebElement registerImgEle;

  @FindBy(xpath = "//input[@id='name']")
          @CacheLookup
    WebElement nameInputEle;

  @FindBy(xpath = "//select[@id='topic']")
          @CacheLookup
    WebElement topicsDropdownEle;


  @FindBy(xpath = "//button[normalize-space()='Register Now']")
          @CacheLookup
    WebElement registerNowBtn;


  @FindBy(xpath = "//p[contains(text(),'Please enter your name')]")
  WebElement errorMsgEle;
public  WebElement getAppLogoImg(){
    return applogoEle;
}

  public  String getHeadingText(){
     return headingEle.getText();
  }

  public  WebElement getRegisterImg(){
    return  registerImgEle;
  }
public  void enterName(String name){
      nameInputEle.sendKeys(name);
}

  public void selectTopicOption(String topic){
      dropdownOptions=new Select(topicsDropdownEle);
      dropdownOptions.selectByValue(topic);
  }

  public  void clickOnRegisterNowBtn(){
      registerNowBtn.click();
  }

  public  void register(String name,  String topic){
      enterName(name);
      selectTopicOption(topic);
      clickOnRegisterNowBtn();
  }

  public  String getErrorMsg(){
    return errorMsgEle.getText();
  }
}
